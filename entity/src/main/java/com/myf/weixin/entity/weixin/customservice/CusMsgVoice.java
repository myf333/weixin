package com.myf.weixin.entity.weixin.customservice;

/**
 * Created by myf on 2016/6/8.
 */
public class CusMsgVoice extends CusMsgBase {
    private MediaIdItem voice;

    public MediaIdItem getVoice() {
        return voice;
    }

    public void setVoice(MediaIdItem voice) {
        this.voice = voice;
    }
}
