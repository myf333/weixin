package com.myf.weixin.entity.weixin.message;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created by myf on 2016/5/20.
 */
public class SendPicsInfo {
    private int Count;
    private List<PicItem> PicList;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public List<PicItem> getPicList() {
        return PicList;
    }

    public void setPicList(List<PicItem> picList) {
        PicList = picList;
    }
}
