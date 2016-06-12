package com.myf.weixin.entity.weixin.card;

/**
 * Created by myf on 2016/6/12.
 */
public class CardDateInfo {
    private CardDateType type;
    private long begin_timestamp;
    private long end_timestamp;

    public CardDateInfo(CardDateType type, long begin_timestamp, long end_timestamp) {
        this.type = type;
        this.begin_timestamp = begin_timestamp;
        this.end_timestamp = end_timestamp;
    }

    public CardDateType getType() {
        return type;
    }

    public void setType(CardDateType type) {
        this.type = type;
    }

    public long getBegin_timestamp() {
        return begin_timestamp;
    }

    public void setBegin_timestamp(long begin_timestamp) {
        this.begin_timestamp = begin_timestamp;
    }

    public long getEnd_timestamp() {
        return end_timestamp;
    }

    public void setEnd_timestamp(long end_timestamp) {
        this.end_timestamp = end_timestamp;
    }
}
