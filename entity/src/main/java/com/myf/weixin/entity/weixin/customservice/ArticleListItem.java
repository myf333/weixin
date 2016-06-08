package com.myf.weixin.entity.weixin.customservice;

import java.util.List;

/**
 * Created by myf on 2016/6/8.
 */
public class ArticleListItem {
    private List<ArticleItem> articles;

    public ArticleListItem(List<ArticleItem> articles) {
        this.articles = articles;
    }

    public List<ArticleItem> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleItem> articles) {
        this.articles = articles;
    }
}
