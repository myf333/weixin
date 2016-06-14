package com.myf.weixin.entity.weixin.customservice;

/**
 * Created by myf on 2016/6/14.
 */
public class CusMsgCard extends CusMsgBase {
    private CardItem wxcard;

    public CardItem getWxcard() {
        return wxcard;
    }

    public void setWxcard(CardItem wxcard) {
        this.wxcard = wxcard;
    }
}
