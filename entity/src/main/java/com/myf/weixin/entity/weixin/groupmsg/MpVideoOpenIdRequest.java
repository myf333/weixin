package com.myf.weixin.entity.weixin.groupmsg;

/**
 * Created by myf on 2016/6/1.
 */
public class MpVideoOpenIdRequest<T> extends GroupMessageRequest {
    private T touser;
    private String towxname;
    private MediaContent mpvideo;

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

    public MediaContent getMpvideo() {
        return mpvideo;
    }

    public void setMpvideo(MediaContent mpvideo) {
        this.mpvideo = mpvideo;
    }
}
