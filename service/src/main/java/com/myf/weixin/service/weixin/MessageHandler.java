package com.myf.weixin.service.weixin;

import com.myf.weixin.entity.weixin.*;
import com.myf.weixin.entity.weixin.message.ResponseMessageText;
import com.myf.weixin.util.StreamUtil;
import com.myf.weixin.util.XMLConvertUtil;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

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
    public MessageHandler(InputStream stream,PostModel model){
        this.model = model;
        Init(stream);
    }

    private void Init(InputStream stream){
        try {
            if("aes".equals(model.getEncrypt_type())){
                isEncrypt = true;
                wxBizMsgCrypt = new WXBizMsgCrypt(model.getToken(), model.getEncodingAESKey(), model.getAppId());
            }
            logger.info("get wxBizMsgCrypt");
            String xml = StreamUtil.copyStreamToString(stream, Charset.forName("utf-8"));
            logger.info(xml);
            if(isEncrypt){
                xml = wxBizMsgCrypt.decryptMsg(model.getMsg_signature(), model.getTimestamp(), model.getNonce(), xml);
            }
            logger.info("decryptMsg");
            logger.info(xml);
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
                break;
            case music:
                break;
            case image:
                break;
            case voice:
                break;
            case video:
                break;
            case transfer_customer_service:
                break;
            default:
                break;
        }
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
                break;
            case image:
                break;
            case voice:
                break;
            case video:
                break;
            case link:
                break;
            case event:
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
        ResponseMessageText responseMessage = (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,ResponseMsgType.text);

        StringBuilder result = new StringBuilder();
        result.append("您刚才发送了文字信息:");
        result.append(requestMessage.getContent());
        responseMessage.setContent(result.toString());
        return responseMessage;
    }
}
