package com.myf.weixin.entity.weixin.groupmsg;

/**
 * Created by myf on 2016/6/1.
 */
public class VoiceOpenIdRequest<T> extends GroupMessageRequest {
    private T touser;
    private String towxname;
    private MediaContent voice;

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

    public MediaContent getVoice() {
        return voice;
    }

    public void setVoice(MediaContent voice) {
        this.voice = voice;
    }
}
