package com.myf.weixin.entity.weixin.groupmsg;

/**
 * Created by myf on 2016/6/1.
 */
public class VoiceRequest extends GroupMessageRequest {
    private GroupFilter filter;
    private MediaContent voice;

    public MediaContent getVoice() {
        return voice;
    }

    public void setVoice(MediaContent voice) {
        this.voice = voice;
    }

    public GroupFilter getFilter() {
        return filter;
    }

    public void setFilter(GroupFilter filter) {
        this.filter = filter;
    }
}
