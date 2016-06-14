package com.myf.weixin.entity.weixin.card.use;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/14.
 */
public class CardHtmlRet extends WxJsonResult {
    private String content;//返回一段html代码，可以直接嵌入到图文消息的正文里。即可以把这段代码嵌入到上传图文消息素材接口中的content字段里。

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
