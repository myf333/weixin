package com.myf.weixin.entity.weixin.shop;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/12.
 */
public class ShopInfoRet extends WxJsonResult{
    private ShopInfoItem business;

    public ShopInfoItem getBusiness() {
        return business;
    }

    public void setBusiness(ShopInfoItem business) {
        this.business = business;
    }
}
