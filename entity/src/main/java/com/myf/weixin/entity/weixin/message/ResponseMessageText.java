package com.myf.weixin.entity.weixin.message;

import com.myf.weixin.entity.weixin.ResponseMessageBase;
import com.myf.weixin.util.XStreamCDATA;

/**
 * Created by myf on 2016/5/18.
 */
public class ResponseMessageText extends ResponseMessageBase {
    @XStreamCDATA
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
