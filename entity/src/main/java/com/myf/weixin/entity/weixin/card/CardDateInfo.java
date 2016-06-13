package com.myf.weixin.entity.weixin.card;

/**
 * Created by myf on 2016/6/12.
 */
public class CardDateInfo {
    private CardDateType type;//DATE_TYPE_FIX_TIME_RANGE表示固定日期区间，DATE_TYPE_FIX_TERM表示固定时长（自领取后按天算
    private long begin_timestamp;//ype为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。从1970年1月1日00:00:00至起用时间的秒数，最终需转换为字符串形态传入。（东八区时间，单位为秒）
    private long end_timestamp;//表示结束时间，建议设置为截止日期的23:59:59过期。（东八区时间，单位为秒）
    private int fixed_term;//type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0。
    private int fixed_begin_term;//type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0。（单位为天）

    public CardDateInfo(CardDateType type, long begin_timestamp, long end_timestamp) {
        this.type = type;
        this.begin_timestamp = begin_timestamp;
        this.end_timestamp = end_timestamp;
    }

    public CardDateInfo(CardDateType type, int  fixed_term, int fixed_begin_term) {
        this.type = type;
        this.fixed_term = fixed_term;
        this.fixed_begin_term = fixed_begin_term;
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
