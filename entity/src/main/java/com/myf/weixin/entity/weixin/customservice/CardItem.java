package com.myf.weixin.entity.weixin.customservice;

import com.myf.weixin.entity.weixin.card.use.CardExt;

/**
 * Created by myf on 2016/6/14.
 */
public class CardItem {
    private String card_id;
    private CardExt card_ext;

    public CardItem(String card_id, CardExt card_ext) {
        this.card_id = card_id;
        this.card_ext = card_ext;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public CardExt getCard_ext() {
        return card_ext;
    }

    public void setCard_ext(CardExt card_ext) {
        this.card_ext = card_ext;
    }
}
