package com.myf.weixin.entity.weixin.media;

import java.util.List;

/**
 * Created by myf on 2016/6/1.
 */
public class MaterialNewsContent {
    private List<Article> news_item;

    public List<Article> getNews_item() {
        return news_item;
    }

    public void setNews_item(List<Article> news_item) {
        this.news_item = news_item;
    }
}
