package com.myf.weixin.entity.weixin.card.use;

/**
 * Created by myf on 2016/6/14.
 */
public class CardLandingItem {
    private String card_id;//所要在页面投放的card_id
    private String thumb_url;//缩略图url

    public CardLandingItem(String card_id, String thumb_url) {
        this.card_id = card_id;
        this.thumb_url = thumb_url;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }
}
