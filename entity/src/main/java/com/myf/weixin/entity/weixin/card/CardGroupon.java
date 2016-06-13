package com.myf.weixin.entity.weixin.card;

/**
 * Created by myf on 2016/6/13.
 */
public class CardGroupon extends CardInfoBase {
    private String deal_detail;//团购券专用，团购详情。

    public CardGroupon(CardBaseInfo base_info, CardAdvancedInfo advanced_info, String deal_detail) {
        super(base_info, advanced_info);
        this.deal_detail = deal_detail;
    }

    public String getDeal_detail() {
        return deal_detail;
    }

    public void setDeal_detail(String deal_detail) {
        this.deal_detail = deal_detail;
    }
}
