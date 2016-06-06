package com.myf.weixin.entity.weixin.template;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/6.
 */
public class TemplateIdRet extends WxJsonResult {
    private String template_id;

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }
}
