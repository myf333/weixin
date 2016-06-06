package com.myf.weixin.service.weixin;

import com.google.gson.Gson;
import com.myf.weixin.entity.weixin.WxJsonResult;
import com.myf.weixin.entity.weixin.oauth.GrantUserInfoRet;
import com.myf.weixin.entity.weixin.oauth.OAuthAccessTokenResult;
import com.myf.weixin.entity.weixin.oauth.Scope;
import com.myf.weixin.util.HttpUtil;

import java.text.MessageFormat;

/**
 * Created by myf on 2016/6/6.
 */
public class OAuthService {
    /**
     * 用户同意授权，获取code
     * appId    公众号的唯一标识
     * redirect_uri 授权后重定向的回调链接地址，请使用urlencode对链接进行处理
     * scope    应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
     * state    重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * **/
    public static String getAuthorizeUrl(String appId,String redirect_uri,Scope scope,String state)throws Exception{
        return MessageFormat.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope={2}&state={3}#wechat_redirect"
                                            ,appId,redirect_uri,scope.toString(),state);
    }

    /**
     * 通过code换取网页授权access_token
     * 由于公众号的secret和获取到的access_token安全级别都非常高，必须只保存在服务器，不允许传给客户端。
     * 后续刷新access_token、通过access_token获取用户信息等步骤，也必须从服务器发起。
     * **/
    public static OAuthAccessTokenResult getAccessToken(String appId,String appSecret,String code)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code",appId,appSecret,code);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url,null);
        return gson.fromJson(res,OAuthAccessTokenResult.class);
    }

    /**
     * 刷新access_token（如果需要）
     * 由于access_token拥有较短的有效期，当access_token超时后，可以使用refresh_token进行刷新，
     * refresh_token拥有较长的有效期（7天、30天、60天、90天），当refresh_token失效的后，需要用户重新授权。
     * **/
    public static OAuthAccessTokenResult refreshAccessToken(String appId,String refresh_token)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid={0}&grant_type=refresh_token&refresh_token={1}",appId,refresh_token);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url,null);
        return gson.fromJson(res,OAuthAccessTokenResult.class);
    }

    /**
     * 检验授权凭证（access_token）是否有效
     * access_token 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * **/
    public static WxJsonResult checkAccessToken(String access_token,String openId)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/sns/auth?access_token={0}&openid={1}",access_token,openId);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url,null);
        return gson.fromJson(res,WxJsonResult.class);
    }

    /**
     *  拉取用户信息(需scope为 snsapi_userinfo)
     * **/
    public static GrantUserInfoRet getUserInfo(String access_token,String openId)throws Exception{
        String url = MessageFormat.format("https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}&lang=zh_CN",access_token,openId);
        Gson gson = new Gson();
        String res = HttpUtil.Get(url,null);
        return gson.fromJson(res,GrantUserInfoRet.class);
    }

}
