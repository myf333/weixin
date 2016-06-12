package com.myf.weixin.entity.weixin.shop;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/12.
 */
public class ShopListRet extends WxJsonResult {
    private List<ShopListItem> business_list;
    private int total_count;//门店总数量

    public List<ShopListItem> getBusiness_list() {
        return business_list;
    }

    public void setBusiness_list(List<ShopListItem> business_list) {
        this.business_list = business_list;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
}
