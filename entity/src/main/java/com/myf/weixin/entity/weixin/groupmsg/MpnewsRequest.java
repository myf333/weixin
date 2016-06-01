package com.myf.weixin.entity.weixin.groupmsg;

/**
 * Created by myf on 2016/6/1.
 */
public class MpnewsRequest extends GroupMessageRequest{
    private GroupFilter filter;
    private MediaContent mpnews;

    public GroupFilter getFilter() {
        return filter;
    }

    public void setFilter(GroupFilter filter) {
        this.filter = filter;
    }

    public MediaContent getMpnews() {
        return mpnews;
    }

    public void setMpnews(MediaContent mpnews) {
        this.mpnews = mpnews;
    }
}
