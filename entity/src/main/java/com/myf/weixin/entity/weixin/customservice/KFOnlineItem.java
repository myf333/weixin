package com.myf.weixin.entity.weixin.customservice;

/**
 * Created by myf on 2016/6/8.
 */
public class KFOnlineItem {
    private String kf_account;//完整客服帐号，格式为：帐号前缀@公众号微信号
    private int status;//客服在线状态，目前为：1、web 在线
    private String kf_id;//客服编号
    private int accepted_case;//客服当前正在接待的会话数

    public String getKf_account() {
        return kf_account;
    }

    public void setKf_account(String kf_account) {
        this.kf_account = kf_account;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getKf_id() {
        return kf_id;
    }

    public void setKf_id(String kf_id) {
        this.kf_id = kf_id;
    }

    public int getAccepted_case() {
        return accepted_case;
    }

    public void setAccepted_case(int accepted_case) {
        this.accepted_case = accepted_case;
    }
}
