package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.WxJsonResult;
import com.myf.weixin.entity.weixin.groupmsg.*;
import com.myf.weixin.entity.weixin.media.MaterialNew;
import com.myf.weixin.entity.weixin.media.MediaUploadRet;
import com.myf.weixin.util.HttpUtil;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by myf on 2016/6/1.
 */
public class GroupMessageService {

    /**
     * 上传图文消息素材【订阅号与服务号认证后均可用】
     * **/
    public static MediaUploadRet uploadNews(String accessToken,MaterialNew news)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(news));
        return gson.fromJson(res,MediaUploadRet.class);
    }

    /**
     * 上传视频，作为群发视频
     *
     * **/
    public static MediaUploadRet uploadVideo(String accessToken,String mediaId,String title,String description) throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,MessageFormat.format("'{'\"media_id\": \"{0}\",\"title\": \"{1}\",\"description\": \"{2}\"'}'",mediaId,title,description));
        return gson.fromJson(res,MediaUploadRet.class);
    }

    /**
     * 删除图文消息
     *
     * **/
    public static WxJsonResult delGroupMsg(String accessToken,String msg_id) throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,String.format("{\"msg_id\":\"%s\"}",msg_id));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     * 根据标签进行群发【订阅号与服务号认证后均可用】
    * **/
    public static GroupMessageRet sendGroupMessageToAll(String accessToken,boolean isToAll,int tagId,
                                                        GroupMessageType type,String mediaIdOrText)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token={0}",accessToken);
        GroupMessageRequest request = new GroupMessageRequest();
        GroupFilter filter = new GroupFilter();
        filter.setIs_to_all(isToAll);
        filter.setTag_id(tagId);
        MediaContent content = new MediaContent();
        content.setMedia_id(mediaIdOrText);
        switch (type)
        {
            case mpnews:
                MpnewsRequest mpnews = new MpnewsRequest();
                mpnews.setFilter(filter);
                mpnews.setMpnews(content);
                request = mpnews;
                break;
            case text:
                TextRequest text = new TextRequest();
                text.setFilter(filter);
                TextContent textContent = new TextContent();
                textContent.setContent(mediaIdOrText);
                text.setText(textContent);
                request = text;
                break;
            case voice:
                VoiceRequest voice = new VoiceRequest();
                voice.setFilter(filter);
                voice.setVoice(content);
                request = voice;
                break;
            case image:
                ImageRequest image = new ImageRequest();
                image.setFilter(filter);
                image.setImage(content);
                request = image;
                break;
            case mpvideo:
                MpVideoRequest mpvideo = new MpVideoRequest();
                mpvideo.setFilter(filter);
                mpvideo.setMpvideo(content);
                request = mpvideo;
                break;
            case wxcard:
                MpWxCardRequest wxcard = new MpWxCardRequest();
                wxcard.setFilter(filter);
                WxCardContent card = new WxCardContent();
                card.setCard_id(mediaIdOrText);
                wxcard.setWxcard(card);
                request = wxcard;
                break;
        }
        request.setMsgtype(type);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(request));
        return gson.fromJson(res,GroupMessageRet.class);
    }

    /**
     * 根据OpenId分组进行群发【订阅号不可用，服务号认证后可用
     * **/
    public static GroupMessageRet sendGroupMessageByOpenId(String accessToken,List<String> openIds, GroupMessageType type,String mediaIdOrText)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token={0}",accessToken);
        GroupMessageRequest request = new GroupMessageRequest();
        MediaContent content = new MediaContent();
        content.setMedia_id(mediaIdOrText);
        switch (type)
        {
            case mpnews:
                MpnewsOpenIdRequest<List<String>> mpnews = new MpnewsOpenIdRequest<>();
                mpnews.setTouser(openIds);
                mpnews.setMpnews(content);
                request = mpnews;
                break;
            case text:
                TextOpenIdRequest<List<String>> text = new TextOpenIdRequest<>();
                TextContent textContent = new TextContent();
                textContent.setContent(mediaIdOrText);
                text.setText(textContent);
                text.setTouser(openIds);
                request = text;
                break;
            case voice:
                VoiceOpenIdRequest<List<String>> voice = new VoiceOpenIdRequest<>();
                voice.setTouser(openIds);
                voice.setVoice(content);
                request = voice;
                break;
            case image:
                ImageOpenIdRequest<List<String>> image = new ImageOpenIdRequest<>();
                image.setTouser(openIds);
                image.setImage(content);
                request = image;
                break;
            case mpvideo:
                MpVideoOpenIdRequest<List<String>> mpvideo = new MpVideoOpenIdRequest<>();
                mpvideo.setTouser(openIds);
                mpvideo.setMpvideo(content);
                request = mpvideo;
                break;
            case wxcard:
                MpWxCardOpenIdRequest<List<String>> wxcard = new MpWxCardOpenIdRequest<>();
                wxcard.setTouser(openIds);
                WxCardContent card = new WxCardContent();
                card.setCard_id(mediaIdOrText);
                wxcard.setWxcard(card);
                request = wxcard;
                break;
        }
        request.setMsgtype(type);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        String res = HttpUtil.postJson(url,json);
        return gson.fromJson(res,GroupMessageRet.class);
    }

    /**
     * 预览接口【订阅号与服务号认证后均可用】
     * 为了满足第三方平台开发者的需求，在保留对openID预览能力的同时，
     * 增加了对指定微信号发送预览的能力，但该能力每日调用次数有限制（100次）
     * touser 接收消息用户对应该公众号的openid，该字段也可以改为towxname，以实现对微信号的预览
     * touser字段都可以改为towxname，这样就可以针对微信号进行预览（而非openID），towxname和touser同时赋值时，以towxname优先
     * **/
    public static GroupMessageRet preview(String accessToken,String touser,String towxname,GroupMessageType type,String mediaIdOrText) throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token={0}",accessToken);
        GroupMessageRequest request = new GroupMessageRequest();
        MediaContent content = new MediaContent();
        content.setMedia_id(mediaIdOrText);
        switch (type)
        {
            case mpnews:
                MpnewsOpenIdRequest<String> mpnews = new MpnewsOpenIdRequest<>();
                mpnews.setTouser(touser);
                mpnews.setTowxname(towxname);
                mpnews.setMpnews(content);
                request = mpnews;
                break;
            case text:
                TextOpenIdRequest<String> text = new TextOpenIdRequest<>();
                TextContent textContent = new TextContent();
                textContent.setContent(mediaIdOrText);
                text.setText(textContent);
                text.setTouser(touser);
                text.setTowxname(towxname);
                request = text;
                break;
            case voice:
                VoiceOpenIdRequest<String> voice = new VoiceOpenIdRequest<>();
                voice.setTouser(touser);
                voice.setVoice(content);
                voice.setTowxname(towxname);
                request = voice;
                break;
            case image:
                ImageOpenIdRequest<String> image = new ImageOpenIdRequest<>();
                image.setTouser(touser);
                image.setImage(content);
                image.setTowxname(towxname);
                request = image;
                break;
            case mpvideo:
                MpVideoOpenIdRequest<String> mpvideo = new MpVideoOpenIdRequest<>();
                mpvideo.setTouser(touser);
                mpvideo.setMpvideo(content);
                mpvideo.setTowxname(towxname);
                request = mpvideo;
                break;
            case wxcard:
                MpWxCardOpenIdRequest<String> wxcard = new MpWxCardOpenIdRequest<>();
                wxcard.setTouser(touser);
                WxCardContent card = new WxCardContent();
                card.setCard_id(mediaIdOrText);
                wxcard.setWxcard(card);
                wxcard.setTowxname(towxname);
                request = wxcard;
                break;
        }
        request.setMsgtype(type);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        String res = HttpUtil.postJson(url,json);
        return gson.fromJson(res,GroupMessageRet.class);
    }



    /**
     * 查询群发消息发送状态【订阅号与服务号认证后均可用】
     * **/
    public static GroupMessageStatus getSendStatus(String accessToken,long msg_id) throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,String.format("{\"msg_id\": \"%s\"}",msg_id));
        return gson.fromJson(res,GroupMessageStatus.class);
    }
}
