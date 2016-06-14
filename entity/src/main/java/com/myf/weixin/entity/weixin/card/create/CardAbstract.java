package com.myf.weixin.entity.weixin.card.create;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by myf on 2016/6/13.
 * 封面摘要结构体名称
 */
public class CardAbstract {
    @SerializedName("abstract")
    private String cardAbstract;//封面摘要简介。
    private List<String> icon_url_list;//封面图片列表，仅支持填入一个封面图片链接，上传图片接口上传获取图片获得链接，填写非CDN链接会报错，并在此填入。建议图片尺寸像素850*350

    public CardAbstract(String cardAbstract, List<String> icon_url_list) {
        this.cardAbstract = cardAbstract;
        this.icon_url_list = icon_url_list;
    }

    public String getCardAbstract() {
        return cardAbstract;
    }

    public void setCardAbstract(String cardAbstract) {
        this.cardAbstract = cardAbstract;
    }

    public List<String> getIcon_url_list() {
        return icon_url_list;
    }

    public void setIcon_url_list(List<String> icon_url_list) {
        this.icon_url_list = icon_url_list;
    }
}
