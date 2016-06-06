package com.myf.weixin.entity.weixin.template;

/**
 * Created by myf on 2016/6/6.
 */
public class TemplateItem {
    private String value;
    private String color;

    public TemplateItem(String value,String color){
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
