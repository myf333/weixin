package com.myf.weixin.entity.weixin.media;

/**
 * Created by myf on 2016/6/1.
 */
public class MaterialBatchGetItem {
    private String media_id;
    private MaterialNewsContent content;
    private String name;//文件名称
    private long update_time;//这篇素材的最后更新时间
    private String url;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public MaterialNewsContent getContent() {
        return content;
    }

    public void setContent(MaterialNewsContent content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
