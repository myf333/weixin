package com.myf.weixin.entity.weixin.shop;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/12.
 */
public class CategoryListRet extends WxJsonResult {
    private List<String> category_list;

    public List<String> getCategory_list() {
        return category_list;
    }

    public void setCategory_list(List<String> category_list) {
        this.category_list = category_list;
    }
}
