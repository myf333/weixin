package com.myf.weixin.entity.weixin.card;

/**
 * Created by myf on 2016/6/13.
 */
public abstract class CardInfoBase {
    private CardBaseInfo base_info;
    private CardAdvancedInfo advanced_info;

    public CardInfoBase(){}

    public CardInfoBase(CardBaseInfo base_info, CardAdvancedInfo advanced_info) {
        this.base_info = base_info;
        this.advanced_info = advanced_info;
    }

    public CardBaseInfo getBase_info() {
        return base_info;
    }

    public void setBase_info(CardBaseInfo base_info) {
        this.base_info = base_info;
    }

    public CardAdvancedInfo getAdvanced_info() {
        return advanced_info;
    }

    public void setAdvanced_info(CardAdvancedInfo advanced_info) {
        this.advanced_info = advanced_info;
    }
}
