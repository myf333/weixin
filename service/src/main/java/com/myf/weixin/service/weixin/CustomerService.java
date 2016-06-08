package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.WxJsonResult;
import com.myf.weixin.entity.weixin.customservice.*;
import com.myf.weixin.util.HttpUtil;

import java.text.MessageFormat;

/**
 * Created by myf on 2016/6/7.
 * 请注意，必须先在公众平台官网为公众号设置微信号后才能使用该能力。
 */
public class CustomerService {
    /**
     * 添加客服帐号
     * 开发者可以通过本接口为公众号添加客服账号，每个公众号最多添加10个客服账号
     * **/
    public static WxJsonResult addKFAccount(String accessToken,KFAccount account)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfaccount/add?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(account));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  修改客服帐号
     * **/
    public static WxJsonResult updateKFAccount(String accessToken,KFAccount account)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfaccount/update?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(account));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  删除客服帐号
     * **/
    public static WxJsonResult delKFAccount(String accessToken,String kf_account)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfaccount/del?access_token={0}&kf_account={1}",accessToken,kf_account);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url, null);
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  设置客服帐号的头像
     *  开发者可调用本接口来上传图片作为客服人员的头像，头像图片文件必须是jpg格式，推荐使用640*640大小的图片以达到最佳效果
     * **/
    public static WxJsonResult uploadHeadImg(String accessToken,String kf_account,String fileName,String filePath)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token={0}&kf_account={1}",accessToken,kf_account);
        Gson gson = new Gson();
        String res = HttpUtil.UploadFile(url,null,"image",fileName,filePath);
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  获取所有客服账号
     *  开发者通过本接口，获取公众号中所设置的客服基本信息，包括客服工号、客服昵称、客服登录账号
     * **/
    public static KFListRet getKFList(String accessToken)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url,null);
        return gson.fromJson(res,KFListRet.class);
    }

    /**
     *  获取客服基本信息-在线客服
     * **/
    public static KFOnlineRet getKFOnlineList(String accessToken)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url,null);
        return gson.fromJson(res,KFOnlineRet.class);
    }

    /**
     *  邀请绑定客服帐号
     *  kf_account 完整客服帐号，格式为：帐号前缀@公众号微信号
     *  invite_wx 接收绑定邀请的客服微信号
     *  新添加的客服帐号是不能直接使用的，只有客服人员用微信号绑定了客服账号后，方可登录Web客服进行操作。
     *  此接口发起一个绑定邀请到客服人员微信号，客服人员需要在微信客户端上用该微信号确认后帐号才可用。
     *  尚未绑定微信号的帐号可以进行绑定邀请操作，邀请未失效时不能对该帐号进行再次绑定微信号邀请。
     *  0	成功
     *  65400	API不可用，即没有开通/升级到新版客服
     *  65401	无效客服帐号
     *  65407	邀请对象已经是本公众号客服
     *  65408	本公众号已发送邀请给该微信号
     *  65409	无效的微信号
     *  65410	邀请对象绑定公众号客服数量达到上限（目前每个微信号最多可以绑定5个公众号客服帐号）
     *  65411	该帐号已经有一个等待确认的邀请，不能重复邀请
     *  65412	该帐号已经绑定微信号，不能进行邀请

     * **/
    public static WxJsonResult inviteWorker(String accessToken,String kf_account,String invite_wx)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfaccount/inviteworker?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url, String.format("{\"kf_account\" : \"%s\",\"invite_wx\" : \"%s\"}",kf_account,invite_wx));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     * 发送客服消息
     * 当用户主动发消息给公众号的时候（包括发送信息、点击自定义菜单、订阅事件、扫描二维码事件、支付成功事件、用户维权），
     * 微信将会把消息数据推送给开发者，开发者在一段时间内（目前修改为48小时）可以调用客服消息接口，
     * 通过POST一个JSON数据包来发送消息给普通用户，在48小时内不限制发送次数。
     * 此接口主要用于客服等有人工消息处理环节的功能，方便开发者为用户提供更加优质的服务
     * **/
    public static <T extends CusMsgBase> WxJsonResult sendCusMessage(String accessToken,T data)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url,gson.toJson(data));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  创建会话
     *  此接口在客服和用户之间创建一个会话，如果该客服和用户会话已存在，则直接返回0。指定的客服帐号必须已经绑定微信号且在线
     *  kf_account  完整客服帐号，格式为：帐号前缀@公众号微信号
     *  openid  粉丝的openid
     * **/
    public static WxJsonResult createKFSession(String accessToken,String kf_account,String openid)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfsession/create?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url, String.format("{\"kf_account\" : \"%s\",\"openid\" : \"%s\"}",kf_account,openid));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  关闭会话
     *  此接口在客服和用户之间创建一个会话，如果该客服和用户会话已存在，则直接返回0。指定的客服帐号必须已经绑定微信号且在线
     *  kf_account  完整客服帐号，格式为：帐号前缀@公众号微信号
     *  openid  粉丝的openid
     * **/
    public static WxJsonResult closeKFSession(String accessToken,String kf_account,String openid)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfsession/close?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.postJson(url, String.format("{\"kf_account\" : \"%s\",\"openid\" : \"%s\"}",kf_account,openid));
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  获取客户会话状态
     *  此接口获取一个客户的会话，如果不存在，则kf_account为空。
     *  openid  粉丝的openid
     * **/
    public static KFSessionRet getSession(String accessToken,String openid)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfsession/getsession?access_token={0}&openid={1}",accessToken,openid);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url, null);
        return gson.fromJson(res,KFSessionRet.class);
    }

    /**
     *  获取客服会话列表
     *  kf_account 完整客服帐号，格式为：帐号前缀@公众号微信号
     * **/
    public static KFSessionListRet getSessionList(String accessToken,String kf_account)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfsession/getsessionlist?access_token={0}&kf_account={1}",accessToken,kf_account);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url, null);
        return gson.fromJson(res,KFSessionListRet.class);
    }

    /**
     * 获取未接入会话列表
     * **/
    public static WaitCaseListRet getWaitCase(String accessToken)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token={0}",accessToken);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url, null);
        return gson.fromJson(res,WaitCaseListRet.class);
    }
}
