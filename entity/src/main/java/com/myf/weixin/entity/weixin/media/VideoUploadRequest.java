package com.myf.weixin.entity.weixin.media;

/**
 * Created by myf on 2016/5/30.
 */
public class VideoUploadRequest {
    private String title;//视频素材的标题
    private String introduction;//视频素材的描述

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
