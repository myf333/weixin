package com.myf.weixin.entity.weixin.card;

/**
 * Created by myf on 2016/6/13.
 */
public class CardCash extends CardInfoBase {
    private int least_cost;//代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0。
    private int reduce_cost;//代金券专用，表示减免金额。（单位为分）

    public CardCash(CardBaseInfo base_info, CardAdvancedInfo advanced_info, int least_cost, int reduce_cost) {
        super(base_info, advanced_info);
        this.least_cost = least_cost;
        this.reduce_cost = reduce_cost;
    }

    public int getLeast_cost() {
        return least_cost;
    }

    public void setLeast_cost(int least_cost) {
        this.least_cost = least_cost;
    }

    public int getReduce_cost() {
        return reduce_cost;
    }

    public void setReduce_cost(int reduce_cost) {
        this.reduce_cost = reduce_cost;
    }
}
