package com.myf.weixin.entity.weixin.message;

import com.myf.weixin.entity.weixin.ResponseMessageBase;

/**
 * Created by myf on 2016/5/19.
 */
public class ResponseMessageVideo  extends ResponseMessageBase {
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
