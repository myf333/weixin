package com.myf.weixin.web.controller;

import com.myf.weixin.entity.Account;
import com.myf.weixin.service.AccountService;
import com.myf.weixin.util.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by myf on 2016/5/4.
 */
@Controller
@RequestMapping(value = "wx/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public @ResponseBody String getList(){
        logger.info("list");
        List<Account> list = accountService.getAccountList();
        Gson gson=new Gson();
        return gson.toJson(list);
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public @ResponseBody String add(@RequestParam String name,@RequestParam String pwd){
        Account account = new Account();
        account.setAccount(name);
        try {
            account.setPassword(EncryptUtil.Encrypt(pwd, "MD5", "UTF-8"));
        }catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
            return e.getMessage();
        }
        account.setBinding(false);
        account.setState(true);
        account.setWeixintype(1);

        account = accountService.addAccount(account);
        Gson gson=new Gson();
        return gson.toJson(account);
    }
}
