package com.myf.weixin.entity.weixin;

import com.myf.weixin.entity.weixin.message.ScanCodeInfo;
import com.myf.weixin.entity.weixin.message.SendLocationInfo;
import com.myf.weixin.entity.weixin.message.SendPicsInfo;

/**
 * Created by myf on 2016/5/18.
 */
public class RequestMessage {
    //base
    private String ToUserName; 		//开发者微信号
    private String FromUserName;	//发送方帐号（一个OpenID）
    private Integer CreateTime;		//消息创建时间 （整型）
    private String MsgType;			//消息类型，event
    private String Event;			//事件类型，subscribe(订阅)、unsubscribe(取消订阅)

    //----扫描带参数二维码事件
    private String EventKey;		//事件KEY值，qrscene_为前缀，后面为二维码的参数值
    private String Ticket;			//二维码的ticket，可用来换取二维码图片


    //----上报地理位置事件
    private String Latitude;		//地理位置纬度
    private String Longitude;		//地理位置经度
    private String Precision;		//地理位置精度

    //普通消息
    private String MsgId;			//消息ID号
    //普通消息--文本
    private String Content;			//文本消息内容
    //普通消息--图片
    private String PicUrl;			//图片消息
    //普通消息--媒体
    private String MediaId;			//mediaId 可以调用多媒体文件下载接口拉取数据
    //普通消息--语音格式
    private String Format;			//语音格式
    //普通消息--语音识别
    private String Recognition;		//开通语音识别功能的识别结果
    //普通消息--视频
    private String ThumbMediaId;	//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    //普通消息--地理位置消息
    private String Location_X;		//地理位置维度
    private String Location_Y;		//地理位置经度
    private String Scale;			//地图缩放大小
    private String Label;			//地理位置信息
    //普通消息--链接消息
    private String Title;
    private String Description;
    private String Url;

    //群发消息通知-----------------start
    //Event	 事件信息，此处为MASSSENDJOBFINISH
    private String Status;/**群发的结构，为“send success”或“send fail”或“err(num)”。
     但send success时，也有可能因用户拒收公众号的消息、系统错误等原因造成少量用户接收失败。err(num)是审核失败的具体原因，可能的情况如下：
     err(10001), 涉嫌广告
     err(20001), 涉嫌政治
     err(20004), 涉嫌社会
     err(20002), 涉嫌色情
     err(20006), 涉嫌违法犯罪
     err(20008), 涉嫌欺诈
     err(20013), 涉嫌版权
     err(22000), 涉嫌互推(互相宣传)
     err(21000), 涉嫌其他*/

    private Integer TotalCount;	//group_id下粉丝数；或者openid_list中的粉丝数

    private Integer FilterCount;//过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount

    private Integer SentCount;//发送成功的粉丝数

    private Integer ErrorCount;//发送失败的粉丝数

    //群发消息通知-----------------end

    private ScanCodeInfo ScanCodeInfo;//扫描信息
    private SendPicsInfo SendPicsInfo;//发送的图片信息

    private String UniqId;//		商户自己内部ID，即字段中的sid
    private String PoiId;//	微信的门店ID，微信内门店唯一标示ID
    private String Result;//	审核结果，成功succ 或失败fail
    private String Msg;//	成功的通知信息，或审核失败的驳回理由

    private String CardId;//卡券审核事件推送/买单事件推送

    private String UserCardCode;//卡券Code码。
    private String TransId;//微信支付交易订单号（只有使用买单功能核销的卡券才会出现）
    private String LocationId;//门店名称，当前卡券核销的门店名称（只有通过卡券商户助手和买单核销时才会出现）
    private String Fee;//实付金额，单位为分
    private String OriginalFee;//应付金额，单位为分

    private int IsGiveByFriend;//是否为转赠，1代表是，0代表否。
    private String OldUserCardCode;//转赠前的code序列号。
    private int OuterId;//领取场景值，用于领取渠道数据统计。可在生成二维码接口及添加JS API接口中自定义该字段的整型值。

    public SendLocationInfo getSendLocationInfo() {
        return SendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
        SendLocationInfo = sendLocationInfo;
    }

    private SendLocationInfo SendLocationInfo;//发送的位置信息

    public SendPicsInfo getSendPicsInfo() {
        return SendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
        SendPicsInfo = sendPicsInfo;
    }

    public ScanCodeInfo getScanCodeInfo() {
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
        ScanCodeInfo = scanCodeInfo;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Integer getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Integer createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Integer getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(Integer totalCount) {
        TotalCount = totalCount;
    }

    public Integer getFilterCount() {
        return FilterCount;
    }

    public void setFilterCount(Integer filterCount) {
        FilterCount = filterCount;
    }

    public Integer getSentCount() {
        return SentCount;
    }

    public void setSentCount(Integer sentCount) {
        SentCount = sentCount;
    }

    public Integer getErrorCount() {
        return ErrorCount;
    }

    public void setErrorCount(Integer errorCount) {
        ErrorCount = errorCount;
    }

    public String getUniqId() {
        return UniqId;
    }

    public void setUniqId(String uniqId) {
        UniqId = uniqId;
    }

    public String getPoiId() {
        return PoiId;
    }

    public void setPoiId(String poiId) {
        PoiId = poiId;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        CardId = cardId;
    }

    public String getUserCardCode() {
        return UserCardCode;
    }

    public void setUserCardCode(String userCardCode) {
        UserCardCode = userCardCode;
    }

    public String getTransId() {
        return TransId;
    }

    public void setTransId(String transId) {
        TransId = transId;
    }

    public String getLocationId() {
        return LocationId;
    }

    public void setLocationId(String locationId) {
        LocationId = locationId;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String fee) {
        Fee = fee;
    }

    public String getOriginalFee() {
        return OriginalFee;
    }

    public void setOriginalFee(String originalFee) {
        OriginalFee = originalFee;
    }

    public int getIsGiveByFriend() {
        return IsGiveByFriend;
    }

    public void setIsGiveByFriend(int isGiveByFriend) {
        IsGiveByFriend = isGiveByFriend;
    }

    public String getOldUserCardCode() {
        return OldUserCardCode;
    }

    public void setOldUserCardCode(String oldUserCardCode) {
        OldUserCardCode = oldUserCardCode;
    }

    public int getOuterId() {
        return OuterId;
    }

    public void setOuterId(int outerId) {
        OuterId = outerId;
    }
}
