package com.myf.weixin.entity.weixin.qrcode;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/6.
 */
public class Long2ShortRet extends WxJsonResult{
    private String short_url;

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }
}
