package com.myf.weixin.entity.weixin.qrcode;

import com.myf.weixin.entity.weixin.WxJsonResult;

/**
 * Created by myf on 2016/6/6.
 */
public class QrCodeRet extends WxJsonResult{
    private String ticket;//获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
    private long expire_seconds;//该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
    private String url;//二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public long getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(long expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
