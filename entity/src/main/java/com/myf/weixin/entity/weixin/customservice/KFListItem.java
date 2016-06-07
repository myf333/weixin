package com.myf.weixin.entity.weixin.customservice;

/**
 * Created by myf on 2016/6/7.
 */
public class KFListItem {
    private String kf_account;//完整客服账号，格式为：账号前缀@公众号微信号
    private String kf_nick;//客服昵称
    private String kf_id;//客服工号
    private String kf_headimgurl;//

    public String getKf_account() {
        return kf_account;
    }

    public void setKf_account(String kf_account) {
        this.kf_account = kf_account;
    }

    public String getKf_nick() {
        return kf_nick;
    }

    public void setKf_nick(String kf_nick) {
        this.kf_nick = kf_nick;
    }

    public String getKf_id() {
        return kf_id;
    }

    public void setKf_id(String kf_id) {
        this.kf_id = kf_id;
    }

    public String getKf_headimgurl() {
        return kf_headimgurl;
    }

    public void setKf_headimgurl(String kf_headimgurl) {
        this.kf_headimgurl = kf_headimgurl;
    }
}
