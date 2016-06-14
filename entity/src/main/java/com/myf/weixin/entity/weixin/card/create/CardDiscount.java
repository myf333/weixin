package com.myf.weixin.entity.weixin.card.create;

/**
 * Created by myf on 2016/6/13.
 */
public class CardDiscount extends CardInfoBase {
    private int discount;//折扣券专用，表示打折额度（百分比）。填30就是七折。

    public CardDiscount(CardBaseInfo base_info, CardAdvancedInfo advanced_info, int discount) {
        super(base_info, advanced_info);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
