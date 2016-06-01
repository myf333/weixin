package com.myf.weixin.entity.weixin.groupmsg;

/**
 * Created by myf on 2016/6/1.
 */
public class TextOpenIdRequest<T> extends GroupMessageRequest{
    private T touser;
    private String towxname;
    private TextContent text;

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

    public TextContent getText() {
        return text;
    }

    public void setText(TextContent text) {
        this.text = text;
    }
}
