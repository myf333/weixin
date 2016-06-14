package com.myf.weixin.entity.weixin.card.use;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/14.
 */
public class CardStatusRet extends WxJsonResult {
    private CardStatusItem card;//
    private String openid;//用户openid
    private boolean can_consume;//是否可以核销，true为可以核销，false为不可核销
    private CardUseStatus user_card_status;//当前code对应卡券的状态

    public CardStatusItem getCard() {
        return card;
    }

    public void setCard(CardStatusItem card) {
        this.card = card;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public boolean isCan_consume() {
        return can_consume;
    }

    public void setCan_consume(boolean can_consume) {
        this.can_consume = can_consume;
    }

    public CardUseStatus getUser_card_status() {
        return user_card_status;
    }

    public void setUser_card_status(CardUseStatus user_card_status) {
        this.user_card_status = user_card_status;
    }
}
