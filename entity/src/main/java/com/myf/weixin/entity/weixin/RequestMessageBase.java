package com.myf.weixin.entity.weixin;

/**
 * Created by myf on 2016/5/18.
 */
public class RequestMessageBase extends MessageBase {
    private RequestMsgType MsgType;

    private long MsgId;

    private String Encrypt;

    public RequestMsgType getMsgType() {
        return MsgType;
    }

    public void setMsgType(RequestMsgType msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }

    public String getEncrypt() {
        return Encrypt;
    }

    public void setEncrypt(String encrypt) {
        Encrypt = encrypt;
    }
}
