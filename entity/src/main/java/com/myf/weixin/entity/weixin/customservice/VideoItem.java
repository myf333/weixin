package com.myf.weixin.entity.weixin.customservice;

/**
 * Created by myf on 2016/6/8.
 */
public class VideoItem {
    private String media_id;
    private String thumb_media_id;
    private String title;
    private String description;

    public VideoItem(String media_id, String thumb_media_id, String title, String description) {
        this.media_id = media_id;
        this.thumb_media_id = thumb_media_id;
        this.title = title;
        this.description = description;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
