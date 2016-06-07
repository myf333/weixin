package com.myf.weixin.entity.weixin.customservice;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/7.
 */
public class KFListRet extends WxJsonResult{
    private List<KFListItem> kf_list;

    public List<KFListItem> getKf_list() {
        return kf_list;
    }

    public void setKf_list(List<KFListItem> kf_list) {
        this.kf_list = kf_list;
    }
}
