package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.myf.weixin.entity.weixin.WxJsonResult;
import com.myf.weixin.entity.weixin.card.create.CardCreateRet;
import com.myf.weixin.entity.weixin.card.create.CardInfoBase;
import com.myf.weixin.entity.weixin.card.create.CardType;
import com.myf.weixin.entity.weixin.card.use.*;
import com.myf.weixin.entity.weixin.qrcode.QrCodeRet;
import com.myf.weixin.util.HttpUtil;

import java.text.MessageFormat;
import java.util.List;

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

    /**
     * 设置自助核销
     * 自助核销与扫码/输码核销互为补充，卡券商户助手通过扫码/输码完成核销的同时，也确保了用券的真实性，适合有强对账需求的商户使用；而自助核销由用户发起，全程由用户操作，适合对账需求不强的商户使用。
     *  目前，自助核销可能适合以下场景使用：
     *  1.不允许店员上班期间带手机；
     *  2.高峰期店内人流量大，扫码/输码核销速度不能满足短时需求；
     *  3.会议入场，短时有大量核销任务；
     *  cardid	卡券ID。
     *  is_open	是否开启自助核销功能，填true/false
     * **/
    public static WxJsonResult setSelfConsume(String accessToken,String cardId,boolean isOpen)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/card/selfconsumecell/set?access_token={0}",accessToken);
        String res = HttpUtil.postJson(url,String.format("{\"card_id\":\"%s\",\"is_open\": %s}",cardId,String.valueOf(isOpen)));
        Gson gson = new Gson();
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     * 创建二维码接口
     * 开发者可调用该接口生成一张卡券二维码供用户扫码后添加卡券到卡包。
     *  自定义Code码的卡券调用接口时，POST数据中需指定code，非自定义code不需指定，指定openid同理。指定后的二维码只能被用户扫描领取一次。
     *  获取二维码ticket后，开发者可用通过ticket换取二维码接口换取二维码图片详情。
     * **/
    public static QrCodeRet createQrcode(String accessToken,Integer expire_seconds,CardQrcodeType type,List<CardQrcodeInfo> list)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/card/qrcode/create?access_token={0}",accessToken);
        JsonObject request = new JsonObject();
        request.addProperty("action_name", type.toString());
        if(null!=expire_seconds)request.addProperty("expire_seconds",expire_seconds);
        Gson gson = new Gson();
        if(type == CardQrcodeType.QR_CARD){
            JsonObject cardInfo = new JsonObject();
            cardInfo.add("card", gson.toJsonTree(list.get(0)));
            request.add("action_info",cardInfo);
        }else{
            JsonObject cardInfo = new JsonObject();
            cardInfo.add("card_list", gson.toJsonTree(list));
            JsonObject multiCard = new JsonObject();
            multiCard.add("multiple_card",cardInfo);
            request.add("action_info",multiCard);
        }
        String res = HttpUtil.postJson(url,gson.toJson(request));
        return gson.fromJson(res,QrCodeRet.class);
    }

    /**
     * 创建货架接口
     * 开发者需调用该接口创建货架链接，用于卡券投放。创建货架时需填写投放路径的场景字段。
     * 卡券货架支持开发者通过调用接口生成一个卡券领取H5页面，并获取页面链接，进行卡券投放动作。
     * 目前卡券货架仅支持非自定义code的卡券，自定义code的卡券需先调用导入code接口将code导入才能正常使用。
     * **/
    public static CardLandingPageRet createLandingPage(String accessToken,CardLandingRequest request)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/card/landingpage/create?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(request));
        return gson.fromJson(res,CardLandingPageRet.class);
    }

    /**
     *  导入code接口
     *  在自定义code卡券成功创建并且通过审核后，必须将自定义code按照与发券方的约定数量调用导入code接口导入微信后台。
     *  接口说明
     *  开发者可调用该接口将自定义code导入微信卡券后台，由微信侧代理存储并下发code。
     *  注： 1）单次调用接口传入code的数量上限为100个。
     *  2）每一个 code 均不能为空串。
     *  3）导入结束后系统会自动判断提供方设置库存与实际导入code的量是否一致。
     *  4）导入失败支持重复导入，提示成功为止。
     *  card_id	需要进行导入code的卡券ID。
     *  code	需导入微信卡券后台的自定义code，上限为100个。
     * **/
    public static CardDepositRet deposit(String accessToken,String cardId,List<String> codeList)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/card/code/deposit?access_token={0}",accessToken);
        Gson gson = new Gson();
        JsonObject request = new JsonObject();
        request.addProperty("card_id",cardId);
        request.add("code", gson.toJsonTree(codeList));
        String res = HttpUtil.postJson(url,gson.toJson(request));
        return gson.fromJson(res,CardDepositRet.class);
    }

    /**
     * 查询导入code数目接口
     * 支持开发者调用该接口查询code导入微信后台成功的数目。
     * **/
    public static CardDepositCountRet getDepositCount(String accessToken,String cardId)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/card/code/getdepositcount?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,String.format("{\"card_id\" : \"%s\"}",cardId));
        return gson.fromJson(res,CardDepositCountRet.class);
    }

    /**
     * 核查code接口
     * 为了避免出现导入差错，强烈建议开发者在查询完code数目的时候核查code接口校验code导入微信后台的情况。
     * **/
    public static CardDepositCheckRet checkCode(String accessToken,String cardId,List<String> codeList)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/card/code/checkcode?access_token={0}",accessToken);
        Gson gson = new Gson();
        JsonObject request = new JsonObject();
        request.addProperty("card_id",cardId);
        request.add("code", gson.toJsonTree(codeList));
        String res = HttpUtil.postJson(url,gson.toJson(request));
        return gson.fromJson(res,CardDepositCheckRet.class);
    }
}
