package com.myf.weixin.entity.weixin.redpack;

/**
 * Created by myf on 2016/8/23.
 */
public class SendRedPack {
    /**
    随机字符串	nonce_str	是	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	String(32)	随机字符串，不长于32位
    **/
    private String nonce_str ;
    /**
    签名	sign	是	C380BEC2BFD727A4B6845133519F3AD6	String(32)	详见签名生成算法
    **/
    private String sign ;
    /**
    商户订单号	mch_billno	是	1.00001E+25	String(28)	商户订单号（每个订单号必须唯一）
    ///	组成： mch_id+yyyymmdd+10位一天内不能重复的数字。
    ///	接口根据商户订单号支持重入， 如出现超时可再调用。
    **/
    private String mch_billno ;
    /**
    商户号	mch_id	是	10000098	String(32)	微信支付分配的商户号
    **/
    private String mch_id ;
    /**
    子商户号	sub_mch_id	否	10000090	String(32)	微信支付分配的子商户号，受理模式下必填
    **/
    private String sub_mch_id ;
    /**
    公众账号appid	wxappid	是	wx8888888888888888	String(32)	商户appid
    **/
    private String wxappid ;
    /**
    提供方名称	nick_name	是	天虹百货	String(32)	提供方名称
    **/
    private String nick_name ;
    /**
    商户名称	send_name	是	天虹百货	String(32)	红包发送者名称
    **/
    private String send_name ;
    /**
    ///用户openid	re_openid	是	oxTWIuGaIt6gTKsQRLau2M0yL16E	String(32)	接受收红包的用户 用户在wxappid下的openid
    **/
    private String re_openid ;
    /**
    ///付款金额	total_amount	是	1000	int	付款金额，单位分
    **/
    private int total_amount ;
    /**
    最小红包金额	min_value	是	1000	int	最小红包金额，单位分
    **/
    private int min_value ;
    /**
    最大红包金额	max_value	是	1000	int	最大红包金额，单位分（ 最小金额等于最大金额： min_value=max_value =total_amount）
    **/
    private int max_value ;
    /**
    红包发放总人数	total_num	是	1	int	红包发放总人数 total_num=1
    **/
    private int total_num ;
    /**
    红包祝福语	wishing	是	感谢您参加猜灯谜活动，祝您元宵节快乐！	String(128)	红包祝福语
    **/
    private String wishing ;
    /**
    Ip地址	client_ip	是	192.168.0.1	String(15)	调用接口的机器Ip地址
    **/
    private String client_ip ;
    /**
    活动名称	act_name	是	猜灯谜抢红包活动	String(32)	活动名称
    **/
    private String act_name ;
    /**
    备注	remark	是	猜越多得越多，快来抢！	String(256)	备注信息
    **/
    private String remark ;
    /**
    商户logo的url	logo_imgurl	否	https://wx.gtimg.com/mch/img/ico-logo.png	String(128)	商户logo的url
    **/
    private String logo_imgurl ;
    /**
    分享文案	share_content	否	快来参加猜灯谜活动	String(256)	分享文案
    **/
    private String share_content ;
    /**
    分享链接	share_url	否	http://www.qq.com	String(128)	分享链接
    **/
    private String share_url ;
    /**
    分享的图片	share_imgurl	否	https://wx.gtimg.com/mch/img/ico-logo.png	String(128)	分享的图片url
    **/
    private String share_imgurl ;

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMch_billno() {
        return mch_billno;
    }

    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public String getWxappid() {
        return wxappid;
    }

    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getSend_name() {
        return send_name;
    }

    public void setSend_name(String send_name) {
        this.send_name = send_name;
    }

    public String getRe_openid() {
        return re_openid;
    }

    public void setRe_openid(String re_openid) {
        this.re_openid = re_openid;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public int getMin_value() {
        return min_value;
    }

    public void setMin_value(int min_value) {
        this.min_value = min_value;
    }

    public int getMax_value() {
        return max_value;
    }

    public void setMax_value(int max_value) {
        this.max_value = max_value;
    }

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public String getWishing() {
        return wishing;
    }

    public void setWishing(String wishing) {
        this.wishing = wishing;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLogo_imgurl() {
        return logo_imgurl;
    }

    public void setLogo_imgurl(String logo_imgurl) {
        this.logo_imgurl = logo_imgurl;
    }

    public String getShare_content() {
        return share_content;
    }

    public void setShare_content(String share_content) {
        this.share_content = share_content;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getShare_imgurl() {
        return share_imgurl;
    }

    public void setShare_imgurl(String share_imgurl) {
        this.share_imgurl = share_imgurl;
    }
}
