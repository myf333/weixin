package com.myf.weixin.entity.weixin.card.create;

/**
 * Created by myf on 2017/6/14.
 */
public class CustomField {
    private FieldNameType name_type;// 否   string(24)   会员信息类目半自定义名称，当开发者变更这类类目信息的value值时可以选择触发系统模板消息通知用户。
    private String name ;//否	string(24) 	会员信息类目自定义名称，当开发者变更这类类目信息的value值时不会触发系统模板消息通知用户
    private String url ;// 否   string（128）   点击类目跳转外链url

    public FieldNameType getName_type() {
        return name_type;
    }

    public void setName_type(FieldNameType name_type) {
        this.name_type = name_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
