package com.myf.weixin.entity.weixin.customservice;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/12.
 */
public class KFRecordRet extends WxJsonResult {
    private List<KFRecordItem> recordlist;

    public List<KFRecordItem> getRecordlist() {
        return recordlist;
    }

    public void setRecordlist(List<KFRecordItem> recordlist) {
        this.recordlist = recordlist;
    }
}
