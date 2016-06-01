package com.myf.weixin.entity.weixin.groupmsg;

/**
 * Created by myf on 2016/6/1.
 */
public class MpVideoRequest extends GroupMessageRequest {
    private GroupFilter filter;
    private MediaContent mpvideo;

    public GroupFilter getFilter() {
        return filter;
    }

    public void setFilter(GroupFilter filter) {
        this.filter = filter;
    }

    public MediaContent getMpvideo() {
        return mpvideo;
    }

    public void setMpvideo(MediaContent mpvideo) {
        this.mpvideo = mpvideo;
    }
}
