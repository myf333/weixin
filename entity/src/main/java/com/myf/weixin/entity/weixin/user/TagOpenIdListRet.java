package com.myf.weixin.entity.weixin.user;

/**
 * Created by myf on 2016/6/2.
 */
public class TagOpenIdListRet {
    private int count;//这次获取的粉丝数量
    private TagOpenIdData data;//粉丝列表
    private String next_openid;//拉取列表最后一个用户的openid

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
