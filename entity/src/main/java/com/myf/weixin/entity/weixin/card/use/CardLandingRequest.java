package com.myf.weixin.entity.weixin.card.use;

import java.util.List;

/**
 * Created by myf on 2016/6/14.
 */
public class CardLandingRequest {
    private String banner;//页面的banner图片链接，须调用，建议尺寸为640*300。
    private String page_title;//页面的title。
    private boolean can_share;//页面是否可以分享,填入true/false
    private CardSceneType scene;//投放页面的场景值；
    private List<CardLandingItem> card_list;//卡券列表，每个item有两个字段

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public boolean isCan_share() {
        return can_share;
    }

    public void setCan_share(boolean can_share) {
        this.can_share = can_share;
    }

    public CardSceneType getScene() {
        return scene;
    }

    public void setScene(CardSceneType scene) {
        this.scene = scene;
    }

    public List<CardLandingItem> getCard_list() {
        return card_list;
    }

    public void setCard_list(List<CardLandingItem> card_list) {
        this.card_list = card_list;
    }
}
