package com.myf.weixin.entity.weixin.customservice;

/**
 * Created by myf on 2016/6/8.
 */
public class CusMsgMusic extends CusMsgBase {
    private MusicItem music;

    public MusicItem getMusic() {
        return music;
    }

    public void setMusic(MusicItem music) {
        this.music = music;
    }
}
