package com.myf.weixin.entity.weixin.message;

import com.myf.weixin.entity.weixin.ResponseMessageBase;

/**
 * Created by myf on 2016/5/19.
 */
public class ResponseMessageVoice  extends ResponseMessageBase {
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
