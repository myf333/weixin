package com.myf.weixin.entity.weixin;

import com.myf.weixin.entity.weixin.message.ResponseMessageNews;
import com.myf.weixin.entity.weixin.message.ResponseMessageText;
import com.myf.weixin.util.XStreamCDATA;

/**
 * Created by myf on 2016/5/18.
 */
public class ResponseMessageBase extends MessageBase {
    @XStreamCDATA
    private ResponseMsgType MsgType;

    public ResponseMsgType getMsgType() {
        return MsgType;
    }

    public void setMsgType(ResponseMsgType msgType) {
        MsgType = msgType;
    }

    public static ResponseMessageBase CreateFromRequestMessage(RequestMessage requestMessage, ResponseMsgType msgType)
    {
        ResponseMessageBase responseMessage = null;
        switch (msgType)
        {
            case text:
                responseMessage = new ResponseMessageText();
                break;
            case news:
                responseMessage = new ResponseMessageNews();
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
        responseMessage.setToUserName(requestMessage.getFromUserName());
        responseMessage.setFromUserName(requestMessage.getToUserName());
        responseMessage.setCreateTime(System.currentTimeMillis()/1000);
        responseMessage.setMsgType(msgType);
        return responseMessage;
    }
}
