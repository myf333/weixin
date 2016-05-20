package com.myf.weixin.entity.weixin.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by myf on 2016/5/20.
 */
@XStreamAlias("item")
public class PicItem {
    private String PicMd5Sum;//	图片的MD5值，开发者若需要，可用于验证接收到图片

    public String getPicMd5Sum() {
        return PicMd5Sum;
    }

    public void setPicMd5Sum(String picMd5Sum) {
        PicMd5Sum = picMd5Sum;
    }
}
