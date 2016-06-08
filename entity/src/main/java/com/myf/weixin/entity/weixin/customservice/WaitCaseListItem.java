package com.myf.weixin.entity.weixin.customservice;

/**
 * Created by myf on 2016/6/8.
 */
public class WaitCaseListItem {
    private long latest_time;//粉丝的最后一条消息的时间
    private String openid;//粉丝的openid

    public long getLatest_time() {
        return latest_time;
    }

    public void setLatest_time(long latest_time) {
        this.latest_time = latest_time;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
