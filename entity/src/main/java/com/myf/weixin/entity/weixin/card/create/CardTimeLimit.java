package com.myf.weixin.entity.weixin.card.create;

/**
 * Created by myf on 2016/6/12.
 * 只控制显示，不控制实际使用逻辑，不填默认不显示
 */
public class CardTimeLimit {
    private CardTimeLimitType type;//
    private Integer begin_hour;//当前type类型下的起始时间（小时），如当前结构体内填写了MONDAY，此处填写了10，则此处表示周一 10:00可用
    private Integer end_hour;//当前type类型下的结束时间（小时），如当前结构体内填写了MONDAY，此处填写了20，则此处表示周一 10:00-20:00可用
    private Integer begin_minute;//当前type类型下的起始时间（分钟），如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59可用
    private Integer end_minute;//当前type类型下的结束时间（分钟），如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59-00:59可用

    public CardTimeLimit(CardTimeLimitType type) {
        this.type = type;
    }

    public CardTimeLimit(CardTimeLimitType type, Integer begin_hour, Integer end_hour, Integer begin_minute, Integer end_minute) {
        this.type = type;
        this.begin_hour = begin_hour;
        this.end_hour = end_hour;
        this.begin_minute = begin_minute;
        this.end_minute = end_minute;
    }

    public CardTimeLimitType getType() {
        return type;
    }

    public void setType(CardTimeLimitType type) {
        this.type = type;
    }

    public Integer getBegin_hour() {
        return begin_hour;
    }

    public void setBegin_hour(Integer begin_hour) {
        this.begin_hour = begin_hour;
    }

    public Integer getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(Integer end_hour) {
        this.end_hour = end_hour;
    }

    public Integer getBegin_minute() {
        return begin_minute;
    }

    public void setBegin_minute(Integer begin_minute) {
        this.begin_minute = begin_minute;
    }

    public Integer getEnd_minute() {
        return end_minute;
    }

    public void setEnd_minute(Integer end_minute) {
        this.end_minute = end_minute;
    }
}
