package com.myf.weixin.entity.weixin.message;

/**
 * Created by myf on 2016/5/19.
 */
public class Video {
    private String MediaId ;
    private String Title;
    private String Description;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
