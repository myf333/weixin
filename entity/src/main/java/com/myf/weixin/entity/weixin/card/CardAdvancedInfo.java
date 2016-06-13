package com.myf.weixin.entity.weixin.card;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by myf on 2016/6/13.
 */
public class CardAdvancedInfo {
    private CardUseCondition use_condition;//使用门槛（条件）字段，若不填写使用条件则在券面拼写：无最低消费限制，全场通用，不限品类；并在使用说明显示：可与其他优惠共享
    @SerializedName("abstract")
    private CardAbstract cardAbstract;//封面摘要结构体名称
    private List<CardTextImage> text_image_list;//图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表
    private List<CardTimeLimit> time_limit;//使用时段限制
    private List<BusinessServiceType> business_service;//商家服务类型：可多选

    public CardUseCondition getUse_condition() {
        return use_condition;
    }

    public void setUse_condition(CardUseCondition use_condition) {
        this.use_condition = use_condition;
    }

    public CardAbstract getCardAbstract() {
        return cardAbstract;
    }

    public void setCardAbstract(CardAbstract cardAbstract) {
        this.cardAbstract = cardAbstract;
    }

    public List<CardTextImage> getText_image_list() {
        return text_image_list;
    }

    public void setText_image_list(List<CardTextImage> text_image_list) {
        this.text_image_list = text_image_list;
    }

    public List<CardTimeLimit> getTime_limit() {
        return time_limit;
    }

    public void setTime_limit(List<CardTimeLimit> time_limit) {
        this.time_limit = time_limit;
    }

    public List<BusinessServiceType> getBusiness_service() {
        return business_service;
    }

    public void setBusiness_service(List<BusinessServiceType> business_service) {
        this.business_service = business_service;
    }
}
