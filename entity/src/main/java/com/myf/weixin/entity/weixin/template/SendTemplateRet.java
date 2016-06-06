package com.myf.weixin.entity.weixin.template;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/6.
 */
public class SendTemplateRet extends WxJsonResult{
    private long msgid;

    public long getMsgid() {
        return msgid;
    }

    public void setMsgid(long msgid) {
        this.msgid = msgid;
    }
}
