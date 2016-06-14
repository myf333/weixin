package com.myf.weixin.entity.weixin.card.use;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/14.
 */
public class CardLandingPageRet extends WxJsonResult {
    private String url;//货架链接。
    private int page_id;//货架ID。货架的唯一标识。

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPage_id() {
        return page_id;
    }

    public void setPage_id(int page_id) {
        this.page_id = page_id;
    }
}
