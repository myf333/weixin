package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.WxJsonResult;
import com.myf.weixin.entity.weixin.card.CardCreateRet;
import com.myf.weixin.entity.weixin.card.CardInfoBase;
import com.myf.weixin.entity.weixin.card.CardType;
import com.myf.weixin.util.HttpUtil;

import java.text.MessageFormat;

/**
 * Created by myf on 2016/6/13.
 */
public class CardService {
    /**
     * 创建卡券
     * 创建卡券接口是微信卡券的基础接口，用于创建一类新的卡券，获取card_id，创建成功并通过审核后，
     * 商家可以通过文档提供的其他接口将卡券下发给用户，每次成功领取，库存数量相应扣除。
     * 开发者须知
     *  1.需自定义Code码的商家必须在创建卡券时候，设定use_custom_code为true，且在调用投放卡券接口时填入指定的Code码。指定OpenID同理。特别注意：在公众平台创建的卡券均为非自定义Code类型。
     *  2.can_share字段指领取卡券原生页面是否可分享，建议指定Code码、指定OpenID等强限制条件的卡券填写false。
     *  3.特别注意：编码方式仅支持使用UTF-8，否则会报错。
     *  4.创建成功后该卡券会自动提交审核，审核结果将通过事件通知商户。开发者可调用设置白名单接口设置用户白名单，领取未通过审核的卡券，测试整个卡券的使用流程。
     *
     *  注意事项：
     *  1.高级字段为商户额外展示信息字段，非必填,但是填入某些结构体后，须填充完整方可显示：如填入text_image_list结构体
     *  时，须同时传入image_url和text，否则也会报错；
     *  2.填入时间限制字段（time_limit）,只控制显示，不控制实际使用逻辑，不填默认不显示
     *  3.创建卡券时，开发者填入的时间戳须注意时间戳溢出时间，设置的时间戳须早于2038年1月19日
     * **/
    public static CardCreateRet createCard(String accessToken,CardType type,CardInfoBase cardInfo)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/card/create?access_token={0}",accessToken);
        String cardName = "";
        switch (type){
            case GROUPON:
                cardName = "groupon";
                break;
            case CASH:
                cardName = "cash";
                break;
            case DISCOUNT:
                cardName = "discount";
                break;
            case GIFT:
                cardName = "gift";
                break;
            case GENERAL_COUPON:
                cardName = "general_coupon";
                break;
        }
        Gson gson = new Gson();
        String json = String.format("{\"card\": {\"card_type\": \"%s\",\"%s\":%s}}",type.toString(),cardName,gson.toJson(cardInfo));
        String res = HttpUtil.postJson(url,json);
        return gson.fromJson(res,CardCreateRet.class);
    }

    /**
     * 设置买单接口
     * 创建卡券之后，开发者可以通过设置微信买单接口设置该card_id支持微信买单功能。
     * 值得开发者注意的是，设置买单的card_id必须已经配置了门店，否则会报错。
     * cardid	卡券ID。
     * is_open	是否开启买单功能，填true/false
     * **/
    public static WxJsonResult setPay(String accessToken,String cardId,boolean isOpen)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/card/paycell/set?access_token={0}",accessToken);
        String res = HttpUtil.postJson(url,String.format("{\"card_id\":\"%s\",\"is_open\": %s}",cardId,String.valueOf(isOpen)));
        Gson gson = new Gson();
        return gson.fromJson(res,WxJsonResult.class);
    }
}
