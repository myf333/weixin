package com.myf.weixin.entity.weixin.customservice;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/8.
 */
public class KFOnlineRet extends WxJsonResult{
    private List<KFOnlineItem> kf_list;

    public List<KFOnlineItem> getKf_list() {
        return kf_list;
    }

    public void setKf_list(List<KFOnlineItem> kf_list) {
        this.kf_list = kf_list;
    }
}
