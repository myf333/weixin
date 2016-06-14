package com.myf.weixin.entity.weixin.card.use;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/14.
 */
public class CardConsumeRet extends WxJsonResult {
    private CardIdItem card;
    private String openid;

    public CardIdItem getCard() {
        return card;
    }

    public void setCard(CardIdItem card) {
        this.card = card;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
