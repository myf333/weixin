package com.myf.weixin.entity.weixin.queue;

/**
 * Created by myf on 2016/5/30.
 */
public class MediaQueueInfo {
    private long accountId;
    private String wxMediaId;
    private long mediaId;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getWxMediaId() {
        return wxMediaId;
    }

    public void setWxMediaId(String wxMediaId) {
        this.wxMediaId = wxMediaId;
    }

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }
}
