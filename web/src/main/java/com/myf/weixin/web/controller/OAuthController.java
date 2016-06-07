package com.myf.weixin.web.controller;

import com.google.gson.Gson;
import com.myf.weixin.entity.Account;
import com.myf.weixin.entity.GrantUser;
import com.myf.weixin.entity.weixin.oauth.GrantUserInfoRet;
import com.myf.weixin.entity.weixin.oauth.OAuthAccessTokenResult;
import com.myf.weixin.entity.weixin.oauth.Scope;
import com.myf.weixin.service.AccountService;
import com.myf.weixin.service.GrantUserService;
import com.myf.weixin.service.weixin.OAuthService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Date;

/**
 * Created by myf on 2016/6/6.
 */
@Controller
@RequestMapping(value = "wx/oauth")
public class OAuthController {
    final Logger logger  =  LoggerFactory.getLogger(getClass());

    @Autowired
    private AccountService accountService;

    @Autowired
    private GrantUserService grantUserService;

    @RequestMapping(value = "oauth")
    public String oauth(String redirectUrl, String cookieName,long uid)throws Exception{
        Account account = accountService.findOne(uid);
        if(account == null) {
            logger.error(String.format("授权用户不存在,uid:%d",uid));
            throw new Exception("用户不存在");
        }
        String grantBackUrl = MessageFormat.format("http://www.codingheart.net/wx/oauth/grantBack?cookieName={0}&uid={1}",cookieName,uid) ;
        String url = OAuthService.getAuthorizeUrl(account.getAppid(), URLEncoder.encode(grantBackUrl, "UTF-8"), Scope.snsapi_userinfo, URLEncoder.encode(redirectUrl, "UTF-8"));
        return MessageFormat.format("redirect:{0}",url);
    }

    @RequestMapping(value = "grantBack")
    public String grantBack(String code,String cookieName,long uid,String state,HttpServletResponse response)throws Exception{
        String url = URLDecoder.decode(state,"UTF-8");
        if(null != code && !"".equals(code)) {
            Account account = accountService.findOne(uid);
            if (account != null) {
                OAuthAccessTokenResult result = OAuthService.getAccessToken(account.getAppid(), account.getAppsecret(), code);
                if (result.getErrcode() == 0) {
                    GrantUserInfoRet ret = OAuthService.getUserInfo(result.getAccess_token(),result.getOpenid());
                    if(ret.getErrcode() == 0){
                        Cookie cookie = new Cookie(cookieName,ret.getOpenid());
                        cookie.setMaxAge(3600*24*365);//1年后过期
                        response.addCookie(cookie);

                        GrantUser user = grantUserService.findByOpenId(ret.getOpenid());
                        if(user == null)
                        {
                            user = new GrantUser();
                            user.setOpenid(ret.getOpenid());
                        }
                        user.setAccesstoken(result.getAccess_token());
                        user.setCity(ret.getCity());
                        user.setCountry(ret.getCountry());
                        user.setExpires_in(result.getExpires_in());
                        user.setHeadimgurl(ret.getHeadimgurl());
                        user.setInputdate(new Date());
                        user.setNickname(ret.getNickname());
                        if(ret.getPrivilege()!=null) {
                            user.setPrivilege(StringUtils.join(ret.getPrivilege().toArray()));
                        }
                        user.setProvince(ret.getProvince());
                        user.setRefreshtoken(result.getRefresh_token());
                        user.setScope(result.getScope());
                        user.setSex(Integer.parseInt(ret.getSex()));
                        user.setUnionid(ret.getUnionid());
                        grantUserService.updateGrantUser(user);
                    }
                }
            }
        }
        return MessageFormat.format("redirect:{0}",url);
    }

    @RequestMapping("grantTest")
    public String grantTest(Model model,@CookieValue(value = "weiXinOpenId",defaultValue = "")String openId) throws Exception{
        if(openId.equals("")){
            String redirectUrl = "http://www.codingheart.net/wx/oauth/grantTest";
            String url = MessageFormat.format("oauth?redirectUrl={0}&cookieName={1}&uid={2}",URLEncoder.encode(redirectUrl,"UTF-8"),"weiXinOpenId",1);
            return MessageFormat.format("redirect:{0}",url);
        }
        model.addAttribute("openId", openId);
        return "grantTest";
    }
}
