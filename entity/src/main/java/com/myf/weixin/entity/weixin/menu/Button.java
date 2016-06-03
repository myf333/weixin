package com.myf.weixin.entity.weixin.menu;

import java.util.List;

/**
 * Created by myf on 2016/6/2.
 */
public class Button {
    private ButtonType type;//菜单的响应动作类型
    private String name;//菜单标题，不超过16个字节，子菜单不超过40个字节
    private String key;//click等点击类型必须	菜单KEY值，用于消息接口推送，不超过128字节
    private String url;//view类型必须	网页链接，用户点击菜单可打开链接，不超过1024字节
    private List<Button> sub_button;//二级菜单数组，个数应为1~5个
    private String media_id;//media_id类型和view_limited类型必须	调用新增永久素材接口返回的合法media_id

    public ButtonType getType() {
        return type;
    }

    public void setType(ButtonType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Button> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Button> sub_button) {
        this.sub_button = sub_button;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
}
