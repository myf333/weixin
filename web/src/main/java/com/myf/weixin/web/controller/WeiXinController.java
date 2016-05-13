package com.myf.weixin.web.controller;

import com.google.gson.Gson;
import com.myf.weixin.entity.Account;
import com.myf.weixin.entity.weixin.PostModel;
import com.myf.weixin.service.AccountService;
import com.myf.weixin.util.CheckSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by myf on 2016/5/13.
 */
@Controller
@RequestMapping(value = "wx/weixin")
public class WeiXinController {
    @Autowired
    private AccountService accountService;

    final Logger logger  =  LoggerFactory.getLogger(WeiXinController.class);

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public @ResponseBody String Index(@RequestParam String signature,
                                      @RequestParam String timestamp,
                                      @RequestParam String nonce,
                                      @RequestParam String echostr,
                                      @RequestParam String sign){
        logger.info(signature+"|"+timestamp+"|"+nonce+"|"+echostr+"|"+sign);
        Account account = accountService.findAccountBySign(sign);
        if(account == null) return "用户不存在";
        if(CheckSignature.Check(signature,timestamp,nonce,account.getToken())) {
            account.setBinding(true);
            accountService.updateAccount(account);
            return echostr;
        }else{
            return "验证签名失败";
        }
    }

    @RequestMapping(value = "index",method = RequestMethod.POST)
    public @ResponseBody String WeiXinPost(PostModel model,String sign){
        Gson gson=new Gson();
        logger.info(gson.toJson(model)+"|"+sign);
        Account account = accountService.findAccountBySign(sign);
        if(account == null) return "用户不存在";
        if(!CheckSignature.Check(model.getSignature(),model.getTimestamp(),model.getNonce(),account.getToken())) {
            return "验证签名失败";
        }
        model.setAppId(account.getAppid());
        model.setEncodingAESKey(account.getEncodingaeskey());
        model.setToken(account.getToken());
        model.setUserId(account.getId());

        return "";
    }
}
