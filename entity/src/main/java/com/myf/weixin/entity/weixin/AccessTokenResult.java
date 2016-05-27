package com.myf.weixin.entity.weixin;

/**
 * Created by myf on 2016/5/23.
 */
public class AccessTokenResult extends WxJsonResult{
    private String access_token;//获取到的凭证
    private long expires_in;// 凭证有效时间，单位：秒

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }
}
