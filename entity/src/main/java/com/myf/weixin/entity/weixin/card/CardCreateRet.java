package com.myf.weixin.entity.weixin.card;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/12.
 */
public class CardCreateRet extends WxJsonResult {
    private String card_id;//卡券ID。

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
}
