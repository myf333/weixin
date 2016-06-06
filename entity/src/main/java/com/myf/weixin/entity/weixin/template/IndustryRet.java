package com.myf.weixin.entity.weixin.template;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/6.
 */
public class IndustryRet extends WxJsonResult{
    private Industry primary_industry;//帐号设置的主营行业
    private Industry secondary_industry;//帐号设置的副营行业

    public Industry getPrimary_industry() {
        return primary_industry;
    }

    public void setPrimary_industry(Industry primary_industry) {
        this.primary_industry = primary_industry;
    }

    public Industry getSecondary_industry() {
        return secondary_industry;
    }

    public void setSecondary_industry(Industry secondary_industry) {
        this.secondary_industry = secondary_industry;
    }
}
