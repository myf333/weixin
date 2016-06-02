package com.myf.weixin.entity.weixin.user;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/2.
 */
public class OpenIdListRet extends WxJsonResult {
    private int total;//关注该公众账号的总用户数
    private int count;//拉取的OPENID个数，最大值为10000
    private TagOpenIdData data;//列表数据，OPENID的列表
    private String next_openid;//拉取列表的最后一个用户的OPENID

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TagOpenIdData getData() {
        return data;
    }

    public void setData(TagOpenIdData data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }
}
