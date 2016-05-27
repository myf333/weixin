package com.myf.weixin.entity.weixin;

/**
 * Created by myf on 2016/5/23.
 */
public class JsAPITicketResult extends WxJsonResult {
    private String ticket;//获取到的凭证
    private int expires_in;//凭证有效时间，单位：秒

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
