package com.myf.weixin.entity.weixin.media;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/5/30.
 */
public class MaterialUploadRet extends WxJsonResult {
    private String media_id;//新增的永久素材的media_id
    private String url;//新增的图片素材的图片URL（仅新增图片素材时会返回该字段）

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
