package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.MediaInfo;
import com.myf.weixin.entity.weixin.*;
import com.myf.weixin.entity.weixin.message.*;
import com.myf.weixin.entity.weixin.queue.MediaQueueInfo;
import com.myf.weixin.entity.weixin.queue.MessageQueueType;
import com.myf.weixin.service.MediaInfoService;
import com.myf.weixin.util.RabbitUtil;
import com.myf.weixin.util.StreamUtil;
import com.myf.weixin.util.XMLConvertUtil;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by myf on 2016/5/18.
 */
public class MessageHandler {
    private PostModel model;
    private RequestMessage requestMessage;
    private ResponseMessageBase responseMessage;
    final Logger logger  =  LoggerFactory.getLogger(MessageHandler.class);
    private boolean isEncrypt = false;
    WXBizMsgCrypt wxBizMsgCrypt;

    @Autowired
    private MediaInfoService mediaInfoService;

    @Autowired
    private RabbitUtil rabbitUtil;

    public void setModel(PostModel model) {
        this.model = model;
    }

    public MessageHandler(){}

    public MessageHandler(InputStream stream,PostModel model){
        this.model = model;
        Init(stream);
    }

    public void Init(InputStream stream){
        try {
            if("aes".equals(model.getEncrypt_type())){
                isEncrypt = true;
                wxBizMsgCrypt = new WXBizMsgCrypt(model.getToken(), model.getEncodingAESKey(), model.getAppId());
            }
            String xml = StreamUtil.copyStreamToString(stream, Charset.forName("utf-8"));
            if(isEncrypt){
                xml = wxBizMsgCrypt.decryptMsg(model.getMsg_signature(), model.getTimestamp(), model.getNonce(), xml);
            }
            requestMessage = XMLConvertUtil.convertToObject(RequestMessage.class,xml);
        }catch (IOException |AesException e){
            logger.error(e.getMessage());
        }
    }

    public String getResponse() throws AesException{
        String xml = "";
        switch (responseMessage.getMsgType()){
            case text:
                xml = XMLConvertUtil.toXML(ResponseMessageText.class,(ResponseMessageText)responseMessage);
                break;
            case news:
                xml = XMLConvertUtil.toXML(ResponseMessageNews.class,(ResponseMessageNews)responseMessage);
                break;
            case music:
                xml = XMLConvertUtil.toXML(ResponseMessageMusic.class,(ResponseMessageMusic)responseMessage);
                break;
            case image:
                xml = XMLConvertUtil.toXML(ResponseMessageImage.class,(ResponseMessageImage)responseMessage);
                break;
            case voice:
                xml = XMLConvertUtil.toXML(ResponseMessageVoice.class,(ResponseMessageVoice)responseMessage);
                break;
            case video:
                xml = XMLConvertUtil.toXML(ResponseMessageVideo.class,(ResponseMessageVideo)responseMessage);
                break;
            case transfer_customer_service:
                break;
            default:
                break;
        }
        logger.info(xml);
        if(isEncrypt)
        {
            String timestamp = String.valueOf(System.currentTimeMillis());
            String nonce =  String.valueOf(System.currentTimeMillis());
            xml = wxBizMsgCrypt.encryptMsg(xml,timestamp,nonce);
        }
        return xml;
    }

    public void execute(){
        if(requestMessage == null) return;
        switch (RequestMsgType.valueOf(requestMessage.getMsgType())){
            case text:
                responseMessage = OnTextRequest(requestMessage);
                break;
            case location:
                responseMessage = OnLocationRequest(requestMessage);
                break;
            case image:
                responseMessage = OnImageRequest(requestMessage);
                break;
            case voice:
                responseMessage = OnVoiceRequest(requestMessage);
                break;
            case video:
                responseMessage = OnVideoRequest(requestMessage);
                break;
            case link:
                responseMessage = OnLinkRequest(requestMessage);
                break;
            case event:
                OnEventRequest(requestMessage);
                break;
            default:
                responseMessage = OnTextRequest(requestMessage);
                break;
        }
    }

    /// <summary>
    /// 处理文本请求（(以返回发送文本消息示例)）
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnTextRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);

        StringBuilder result = new StringBuilder();
        result.append("您刚才发送了文字信息:");
        result.append(requestMessage.getContent());
        responseMessage.setContent(result.toString());
        return responseMessage;
    }

    // <summary>
    /// 处理图片请求(以发送图文消息示例)
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageNews OnImageRequest(RequestMessage requestMessage)
    {
        ResponseMessageNews responseMessage =
                (ResponseMessageNews)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.news);
        ArrayList<Article> list = new ArrayList<>();
        Article item = new Article();
        item.setTitle("您刚才发送了图片信息");
        item.setDescription("您发送的图片将会显示在边上");
        item.setPicUrl(requestMessage.getPicUrl());
        item.setUrl("http://www.baidu.com");
        list.add(item);
        Article item2 = new Article();
        item2.setTitle("第二条");
        item2.setDescription("第二条带连接的内容");
        item2.setPicUrl(requestMessage.getPicUrl());
        item2.setUrl("http://www.qq.com");
        list.add(item2);
        responseMessage.setArticleCount(list.size());
        responseMessage.setArticles(list);

        MediaInfo info = new MediaInfo();
        info.setAccountId(model.getUserId());
        info.setMediatype(requestMessage.getMsgType());
        info.setWxMediaId(requestMessage.getMediaId());
        info.setMediaurl(requestMessage.getPicUrl());
        info.setInputdate(new Date());
        info = mediaInfoService.AddMediaInfo(info);

        //写入消息队列，下载媒体文件
        MediaQueueInfo queueInfo = new MediaQueueInfo();
        queueInfo.setAccountId(info.getAccountId());
        queueInfo.setMediaId(info.getId());
        queueInfo.setWxMediaId(info.getWxMediaId());
        Gson gson = new Gson();
        rabbitUtil.sendData(MessageQueueType.mediaQueue.toString(),gson.toJson(queueInfo));

        return responseMessage;
    }

    /// <summary>
    /// 处理语音请求(以发送音乐消息示例)
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageMusic OnVoiceRequest(RequestMessage requestMessage)
    {
        ResponseMessageMusic responseMessage =
                (ResponseMessageMusic)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.music);
        Music music = new Music();
        music.setMusicUrl("http://weixin.senparc.com/Content/music1.mp3");
        music.setDescription("来自Jeffrey Su的美妙歌声~~");
        music.setTitle("这里是一条音乐消息");
        music.setThumbMediaId("CIX0pyM_WcToQCC5wUUMrev3k4y0bePOni5omEb1v-C5ckfGZFi1u-qL2UmigXtr");
        responseMessage.setMusic(music);
        return responseMessage;
    }

    /// <summary>
    /// 处理视频请求(以返回视频信息为例)
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageVideo OnVideoRequest(RequestMessage requestMessage)
    {
        ResponseMessageVideo responseMessage =
                (ResponseMessageVideo)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.video);
        Video video = new Video();
        video.setMediaId(requestMessage.getMediaId());
        video.setTitle("视频");
        video.setDescription("您发送的视频");
        responseMessage.setVideo(video);
        return responseMessage;
    }

    // <summary>
    /// 处理位置请求(以发送文本消息示例)
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnLocationRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent(String.format("您发送了一条地理位置信息消息，X:%s,Y:%s ",requestMessage.getLocation_X(),requestMessage.getLocation_Y()));
        return responseMessage;
    }

    /// <summary>
    /// 处理链接消息请求(以返回文本信息为例)
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnLinkRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent(MessageFormat.format("您上传了一个连接,连接地址:{0},标题:{1},描述:{2}",
                requestMessage.getUrl(),requestMessage.getTitle(),requestMessage.getDescription()));
        return responseMessage;
    }

    /// <summary>
    /// Event事件类型请求
    /// </summary>
    public void OnEventRequest(RequestMessage requestMessage)
    {
        switch (EventType.valueOf(requestMessage.getEvent())){
            case subscribe:
                responseMessage = OnEvent_SubscribeRequest(requestMessage);
                break;
            case unsubscribe:
                responseMessage = OnEvent_SubscribeRequest(requestMessage);
                break;
            case scan:
                responseMessage = OnEvent_ScanRequest(requestMessage);
                break;
            case LOCATION:
                responseMessage = OnEvent_LocationRequest(requestMessage);
                break;
            case CLICK:
                responseMessage = OnEvent_ClickRequest(requestMessage);
                break;
            case VIEW:
                responseMessage = OnEvent_ViewRequest(requestMessage);
                break;
            case scancode_push:
                responseMessage = OnEvent_ScancodePushRequest(requestMessage);
                break;
            case scancode_waitmsg:
                responseMessage = OnEvent_ScancodeWaitmsgRequest(requestMessage);
                break;
            case pic_sysphoto:
                responseMessage = OnEvent_PicSysphotoRequest(requestMessage);
                break;
            case pic_photo_or_album:
                responseMessage = OnEvent_PicPhotoOrAlbumRequest(requestMessage);
                break;
            case pic_weixin:
                responseMessage = OnEvent_PicWeixinRequest(requestMessage);
                break;
            case location_select:
                responseMessage = OnEvent_LocationSelectRequest(requestMessage);
                break;
            case MASSSENDJOBFINISH:
                responseMessage = OnEvent_MassSendJobFinishRequest(requestMessage);
                break;
            case TEMPLATESENDJOBFINISH:
                responseMessage = OnEvent_TemplateSendJobFinishRequest(requestMessage);
                break;
            default:
                break;
        }
    }

    /// <summary>
    /// 订阅（关注）事件
    /// </summary>
    /// <returns></returns>
    public ResponseMessageText OnEvent_SubscribeRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        if (requestMessage.getEventKey().contains("qrscene_"))//扫描场景二维码关注
        {
            responseMessage.setContent(String.format("扫描场景二维码关注，二维码参数:%s",requestMessage.getEventKey()));
        }else{
            responseMessage.setContent(String.format("您好%s,欢迎关注码农之心",requestMessage.getFromUserName()));
        }
        return responseMessage;
    }

    /// <summary>
    /// 退订
    /// 实际上用户无法收到非订阅账号的消息，所以这里可以随便写。
    /// unsubscribe事件的意义在于及时删除网站应用中已经记录的OpenID绑定，消除冗余数据。并且关注用户流失的情况。
    /// </summary>
    /// <returns></returns>
    public ResponseMessageText OnEvent_UnsubscribeRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent("有空再来");
        return responseMessage;
    }

    /// <summary>
    /// 场景二维码扫描（回复文本消息）
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnEvent_ScanRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent(MessageFormat.format("扫描场景二维码。EventKey:{0},Ticket:{1}", requestMessage.getEventKey(), requestMessage.getTicket()));
        return responseMessage;
    }

    /// <summary>
    /// 上报地理位置
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnEvent_LocationRequest(RequestMessage requestMessage)
    {
        //这里是微信客户端（通过微信服务器）自动发送过来的位置信息
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent(MessageFormat.format("您当前的纬度：{0}，经度：{1},地图精度：{2}", requestMessage.getLatitude(), requestMessage.getLongitude(), requestMessage.getPrecision()));//生产应用时可记录到数据库
        return responseMessage;//这里也可以返回null（需要注意写日志时候null的问题）
    }

    /// <summary>
    /// 菜单点击事件
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnEvent_ClickRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        //菜单点击，需要跟创建菜单时的Key匹配
        switch (requestMessage.getEventKey())
        {
            default:
            {
                responseMessage.setContent(String.format("您点击了菜单：%s",requestMessage.getEventKey()));
            }
            break;
        }
        return responseMessage;
    }

    /// <summary>
    /// 菜单之页面跳转
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnEvent_ViewRequest(RequestMessage requestMessage)
    {
        //说明：这条消息只作为接收，下面的responseMessage到达不了客户端，类似OnEvent_UnsubscribeRequest
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent(String.format("您点击了view按钮，将打开网页：%s" ,requestMessage.getEventKey()));
        return responseMessage;
    }

    /// <summary>
    /// 事件之扫码推事件(scancode_push)
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnEvent_ScancodePushRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent(String.format("事件之扫码推事件,扫描结果为：%s", requestMessage.getScanCodeInfo().getScanResult()));
        return responseMessage;
    }

    /// <summary>
    /// 事件之扫码推事件且弹出“消息接收中”提示框(scancode_waitmsg)
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnEvent_ScancodeWaitmsgRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent(String.format("事件之扫码推事件且弹出“消息接收中”提示框,扫描结果为：%s", requestMessage.getScanCodeInfo().getScanResult()));
        return responseMessage;
    }

    /// <summary>
    /// 事件之弹出拍照或者相册发图（pic_photo_or_album）
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnEvent_PicPhotoOrAlbumRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent(String.format("事件之弹出拍照或者相册发图,发送图片数量为：%d", requestMessage.getSendPicsInfo().getCount()));
        return responseMessage;
    }

    /// <summary>
    /// 事件之弹出系统拍照发图(pic_sysphoto)
    /// 实际测试时发现微信并没有推送RequestMessageEvent_Pic_Sysphoto消息，只能接收到用户在微信中发送的图片消息。
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnEvent_PicSysphotoRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent(String.format("事件之弹出系统拍照发图,发送图片数量为：%d", requestMessage.getSendPicsInfo().getCount()));
        return responseMessage;
    }

    /// <summary>
    /// 事件之弹出微信相册发图器(pic_weixin)
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnEvent_PicWeixinRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent(String.format("事件之弹出微信相册发图器,发送图片数量为：%d", requestMessage.getSendPicsInfo().getCount()));
        return responseMessage;
    }

    /// <summary>
    /// 事件之弹出地理位置选择器（location_select）
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnEvent_LocationSelectRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent(String.format("事件之弹出地理位置选择器,位置为:%s", requestMessage.getSendLocationInfo().getLabel()));
        return responseMessage;
    }

    /// <summary>
    /// 事件之推送群发结果
    /// </summary>
    /// <param name="requestMessage"></param>
    /// <returns></returns>
    public ResponseMessageText OnEvent_MassSendJobFinishRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent("接收到了群发完成的信息。");
        return responseMessage;
    }

    /// <summary>
    /// 发送模板消息返回结果
    /// </summary>
    /// <returns></returns>
    public ResponseMessageText OnEvent_TemplateSendJobFinishRequest(RequestMessage requestMessage)
    {
        ResponseMessageText responseMessage =
                (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);
        responseMessage.setContent("接收到了模板消息发完成的信息。");
        return responseMessage;
    }
}
