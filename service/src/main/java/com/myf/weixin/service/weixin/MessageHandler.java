package com.myf.weixin.service.weixin;

import com.myf.weixin.entity.weixin.*;
import com.myf.weixin.entity.weixin.message.ResponseMessageText;
import com.myf.weixin.util.StreamUtil;
import com.myf.weixin.util.XMLConvertUtil;
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
    private ResponseMsgType msgType;
    final Logger logger  =  LoggerFactory.getLogger(MessageHandler.class);

    public MessageHandler(InputStream stream,PostModel model){
        this.model = model;
        Init(stream);
    }

    private void Init(InputStream stream){
        try {
            String xml = StreamUtil.copyStreamToString(stream, Charset.forName("utf-8"));
            requestMessage = XMLConvertUtil.convertToObject(RequestMessage.class,xml);
            msgType = ResponseMsgType.valueOf(requestMessage.getMsgType());
        }catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    public String getResponse() {
        String xml = "";
        switch (msgType){
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
        ResponseMessageText responseMessage = (ResponseMessageText)ResponseMessageBase.CreateFromRequestMessage(requestMessage,msgType);

        StringBuilder result = new StringBuilder();
        result.append("您刚才发送了文字信息:");
        result.append(requestMessage.getContent());
        responseMessage.setContent(result.toString());
        return responseMessage;
    }
}
