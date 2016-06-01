package com.myf.weixin.entity.weixin.media;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/1.
 */
public class MaterialBatchGet extends WxJsonResult{
    private int total_count;
    private int item_count;
    private List<MaterialBatchGetItem> item;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public List<MaterialBatchGetItem> getItem() {
        return item;
    }

    public void setItem(List<MaterialBatchGetItem> item) {
        this.item = item;
    }
}
