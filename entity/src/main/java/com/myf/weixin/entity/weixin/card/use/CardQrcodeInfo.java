package com.myf.weixin.entity.weixin.card.use;

/**
 * Created by myf on 2016/6/14.
 */
public class CardQrcodeInfo {
    private String card_id;//卡券ID。
    private String code;//卡券Code码,use_custom_code字段为true的卡券必须填写，非自定义code不必填写。
    private String openid;//指定领取者的openid，只有该用户能领取。bind_openid字段为true的卡券必须填写，非指定openid不必填写。
    private Boolean is_unique_code;//指定下发二维码，生成的二维码随机分配一个code，领取后不可再次扫描。填写true或false。默认false，注意填写该字段时，卡券须通过审核且库存不为0。
    private Integer outer_id;//领取场景值，用于领取渠道的数据统计，默认值为0，字段类型为整型，长度限制为60位数字。用户领取卡券后触发的事件推送中会带上此自定义场景值。
    private String outer_str;//outer_id字段升级版本，用户首次领卡时，会通过事件推送给商户；对于会员卡的二维码，用户每次扫码打开会员卡后点击任何url，会将该值拼入url中，方便开发者定位扫码来源

    public CardQrcodeInfo(String card_id, String code) {
        this.card_id = card_id;
        this.code = code;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Boolean getIs_unique_code() {
        return is_unique_code;
    }

    public void setIs_unique_code(Boolean is_unique_code) {
        this.is_unique_code = is_unique_code;
    }

    public Integer getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(Integer outer_id) {
        this.outer_id = outer_id;
    }

    public String getOuter_str() {
        return outer_str;
    }

    public void setOuter_str(String outer_str) {
        this.outer_str = outer_str;
    }
}
