package com.myf.weixin.entity.weixin.groupmsg;

/**
 * Created by myf on 2016/6/1.
 */
public class MpWxCardRequest extends GroupMessageRequest {
    private GroupFilter filter;
    private WxCardContent wxcard;

    public GroupFilter getFilter() {
        return filter;
    }

    public void setFilter(GroupFilter filter) {
        this.filter = filter;
    }

    public WxCardContent getWxcard() {
        return wxcard;
    }

    public void setWxcard(WxCardContent wxcard) {
        this.wxcard = wxcard;
    }
}
