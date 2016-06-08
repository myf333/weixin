package com.myf.weixin.entity.weixin.customservice;

import com.myf.weixin.entity.weixin.WxJsonResult;

import java.util.List;

/**
 * Created by myf on 2016/6/8.
 */
public class WaitCaseListRet extends WxJsonResult {
    private int count;//未接入会话数量
    private List<WaitCaseListItem> waitcaselist;//未接入会话列表，最多返回100条数据，按照来访顺序

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<WaitCaseListItem> getWaitcaselist() {
        return waitcaselist;
    }

    public void setWaitcaselist(List<WaitCaseListItem> waitcaselist) {
        this.waitcaselist = waitcaselist;
    }
}
