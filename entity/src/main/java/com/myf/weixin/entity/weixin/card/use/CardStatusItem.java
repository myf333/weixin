package com.myf.weixin.entity.weixin.card.use;

/**
 * Created by myf on 2016/6/14.
 */
public class CardStatusItem {
    private String card_id;
    private long begin_time;
    private long end_time;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public long getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(long begin_time) {
        this.begin_time = begin_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }
}
