package com.myf.weixin.entity.weixin.message;

import com.myf.weixin.entity.weixin.ResponseMessageBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by myf on 2016/5/19.
 */
public class ResponseMessageNews extends ResponseMessageBase {
    private int ArticleCount;
    private List<Article> Articles;
    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
