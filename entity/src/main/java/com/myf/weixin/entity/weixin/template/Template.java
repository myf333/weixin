package com.myf.weixin.entity.weixin.template;

/**
 * Created by myf on 2016/6/6.
 */
public class Template {
    private String template_id;//模板ID
    private String title;//模板标题
    private String primary_industry;//模板所属行业的一级行业
    private String deputy_industry;//模板所属行业的二级行业
    private String content;//模板内容
    private String example;//模板示例

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimary_industry() {
        return primary_industry;
    }

    public void setPrimary_industry(String primary_industry) {
        this.primary_industry = primary_industry;
    }

    public String getDeputy_industry() {
        return deputy_industry;
    }

    public void setDeputy_industry(String deputy_industry) {
        this.deputy_industry = deputy_industry;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
