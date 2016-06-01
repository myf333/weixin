package com.myf.weixin.entity.weixin.media;

/**
 * Created by myf on 2016/6/1.
 */
public class MaterialNewsUpdate {
    private String media_id;
    private int index;//要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
    private Article articles;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Article getArticles() {
        return articles;
    }

    public void setArticles(Article articles) {
        this.articles = articles;
    }
}
