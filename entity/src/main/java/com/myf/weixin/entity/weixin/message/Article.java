package com.myf.weixin.entity.weixin.message;

import com.myf.weixin.util.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by myf on 2016/5/19.
 */
@XStreamAlias("item")
public class Article {
    @XStreamCDATA
    private String Title;
    @XStreamCDATA
    private String Description ;
    @XStreamCDATA
    private String PicUrl;
    @XStreamCDATA
    private String Url;

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

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
