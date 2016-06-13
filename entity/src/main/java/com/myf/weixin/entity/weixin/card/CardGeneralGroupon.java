package com.myf.weixin.entity.weixin.card;

/**
 * Created by myf on 2016/6/13.
 */
public class CardGeneralGroupon extends CardInfoBase {
    private String default_detail;//优惠券专用，填写优惠详情。

    public CardGeneralGroupon(CardBaseInfo base_info, CardAdvancedInfo advanced_info, String default_detail) {
        super(base_info, advanced_info);
        this.default_detail = default_detail;
    }

    public String getDefault_detail() {
        return default_detail;
    }

    public void setDefault_detail(String default_detail) {
        this.default_detail = default_detail;
    }
}
