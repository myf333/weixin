package com.myf.weixin.entity.weixin.message;

import com.myf.weixin.entity.weixin.ResponseMessageBase;

/**
 * Created by myf on 2016/5/19.
 */
public class ResponseMessageImage  extends ResponseMessageBase {
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
