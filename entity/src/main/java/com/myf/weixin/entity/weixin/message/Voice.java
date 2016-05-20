package com.myf.weixin.entity.weixin.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by myf on 2016/5/19.
 */
@XStreamAlias("Voice")
public class Voice {
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
