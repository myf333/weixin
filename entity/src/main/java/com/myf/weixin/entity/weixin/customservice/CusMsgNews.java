package com.myf.weixin.entity.weixin.customservice;

/**
 * Created by myf on 2016/6/8.
 */
public class CusMsgNews extends CusMsgBase {
    private ArticleListItem news;

    public ArticleListItem getNews() {
        return news;
    }

    public void setNews(ArticleListItem news) {
        this.news = news;
    }
}
