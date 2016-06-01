package com.myf.weixin.entity.weixin.groupmsg;

/**
 * Created by myf on 2016/6/1.
 */
public class MpWxCardOpenIdRequest<T> extends GroupMessageRequest {
    private T touser;
    private String towxname;
    private WxCardContent wxcard;

    public T getTouser() {
        return touser;
    }

    public void setTouser(T touser) {
        this.touser = touser;
    }

    public String getTowxname() {
        return towxname;
    }

    public void setTowxname(String towxname) {
        this.towxname = towxname;
    }

    public WxCardContent getWxcard() {
        return wxcard;
    }

    public void setWxcard(WxCardContent wxcard) {
        this.wxcard = wxcard;
    }
}
