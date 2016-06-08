package com.myf.weixin.entity.weixin.customservice;

/**
 * Created by myf on 2016/6/8.
 */
public class CusMsgBase {
    private String touser;
    private CusMsgType msgtype;
    private KFAccountItem customservice;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public CusMsgType getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(CusMsgType msgtype) {
        this.msgtype = msgtype;
    }

    public KFAccountItem getCustomservice() {
        return customservice;
    }

    public void setCustomservice(KFAccountItem customservice) {
        this.customservice = customservice;
    }
}
