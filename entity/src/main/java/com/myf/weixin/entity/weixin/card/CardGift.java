package com.myf.weixin.entity.weixin.card;

/**
 * Created by myf on 2016/6/13.
 */
public class CardGift extends CardInfoBase {
    private String gift;//兑换券专用，填写兑换内容的名称。

    public CardGift(CardBaseInfo base_info, CardAdvancedInfo advanced_info, String gift) {
        super(base_info, advanced_info);
        this.gift = gift;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }
}
