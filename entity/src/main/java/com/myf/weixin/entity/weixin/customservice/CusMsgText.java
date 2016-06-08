package com.myf.weixin.entity.weixin.customservice;

/**
 * Created by myf on 2016/6/8.
 */
public class CusMsgText extends CusMsgBase {
    private TextContentItem text;

    public TextContentItem getText() {
        return text;
    }

    public void setText(TextContentItem text) {
        this.text = text;
    }
}
