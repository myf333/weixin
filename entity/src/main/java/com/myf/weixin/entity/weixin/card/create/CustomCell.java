package com.myf.weixin.entity.weixin.card.create;

/**
 * Created by myf on 2017/6/14.
 */
public class CustomCell {
    private String name;//   是   string（15）   入口名称。
    private String tips;//  是   string（18）   入口右侧提示语，6个汉字内。
    private String url;// 是   string（128）   入口跳转链接。

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
