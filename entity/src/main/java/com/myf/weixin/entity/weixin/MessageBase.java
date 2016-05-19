package com.myf.weixin.entity.weixin;

import com.myf.weixin.util.XStreamCDATA;

/**
 * Created by myf on 2016/5/18.
 */
public class MessageBase {
    @XStreamCDATA
    private String ToUserName;
    @XStreamCDATA
    private String FromUserName;
    private long CreateTime;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }
}
