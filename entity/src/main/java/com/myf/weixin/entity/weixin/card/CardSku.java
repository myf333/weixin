package com.myf.weixin.entity.weixin.card;

/**
 * Created by myf on 2016/6/12.
 */
public class CardSku {
    private long quantity;

    public CardSku(long quantity) {
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
