package com.myf.weixin.entity.weixin.message;

import com.myf.weixin.entity.weixin.ResponseMessageBase;

/**
 * Created by myf on 2016/5/19.
 */
public class ResponseMessageMusic extends ResponseMessageBase{
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
