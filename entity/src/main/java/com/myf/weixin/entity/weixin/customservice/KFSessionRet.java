package com.myf.weixin.entity.weixin.customservice;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/8.
 */
public class KFSessionRet extends WxJsonResult {
    private long createtime;//会话接入的时间
    private String kf_account;//正在接待的客服，为空表示没有人在接待

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public String getKf_account() {
        return kf_account;
    }

    public void setKf_account(String kf_account) {
        this.kf_account = kf_account;
    }
}
