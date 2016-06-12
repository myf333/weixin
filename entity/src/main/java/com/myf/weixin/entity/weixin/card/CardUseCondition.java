package com.myf.weixin.entity.weixin.card;

/**
 * Created by myf on 2016/6/12.
 */
public class CardUseCondition {
    private String accept_category;
    private String reject_category;
    private boolean can_use_with_other_discount;

    public CardUseCondition(String accept_category, String reject_category, boolean can_use_with_other_discount) {
        this.accept_category = accept_category;
        this.reject_category = reject_category;
        this.can_use_with_other_discount = can_use_with_other_discount;
    }

    public String getAccept_category() {
        return accept_category;
    }

    public void setAccept_category(String accept_category) {
        this.accept_category = accept_category;
    }

    public String getReject_category() {
        return reject_category;
    }

    public void setReject_category(String reject_category) {
        this.reject_category = reject_category;
    }

    public boolean isCan_use_with_other_discount() {
        return can_use_with_other_discount;
    }

    public void setCan_use_with_other_discount(boolean can_use_with_other_discount) {
        this.can_use_with_other_discount = can_use_with_other_discount;
    }
}
