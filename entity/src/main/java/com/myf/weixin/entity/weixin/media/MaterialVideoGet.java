package com.myf.weixin.entity.weixin.media;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/1.
 */
public class MaterialVideoGet extends WxJsonResult{
    private String title;
    private String description;
    private String down_url;

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

    public String getDown_url() {
        return down_url;
    }

    public void setDown_url(String down_url) {
        this.down_url = down_url;
    }
}
