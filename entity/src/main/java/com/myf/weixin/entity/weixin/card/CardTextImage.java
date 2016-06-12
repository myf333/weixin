package com.myf.weixin.entity.weixin.card;

/**
 * Created by myf on 2016/6/12.
 */
public class CardTextImage {
    private String image_url;
    private String text;

    public CardTextImage(String image_url, String text) {
        this.image_url = image_url;
        this.text = text;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
