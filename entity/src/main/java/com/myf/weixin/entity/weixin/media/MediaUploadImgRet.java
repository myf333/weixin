package com.myf.weixin.entity.weixin.media;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/5/30.
 */
public class MediaUploadImgRet extends WxJsonResult {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
