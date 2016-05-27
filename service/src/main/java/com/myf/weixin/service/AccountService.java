package com.myf.weixin.service;

import com.myf.weixin.entity.Account;
import com.myf.weixin.repository.impl.SpringJPAAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by myf on 2016/5/4.
 */
public class AccountService {

    @Autowired
    private SpringJPAAccountRepository accountRepository;

    @Transactional
    public Account addAccount(Account account){
        return accountRepository.save(account);
    }

    @Transactional
    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }

    public List<Account> getAccountList(){
        List<Account> list = new ArrayList<>();
        Iterator<Account> it = accountRepository.findAll().iterator();
//        while (it.hasNext()){
//            list.add(it.next());
//        }
        it.forEachRemaining(list::add);
        return list;
    }

    public Account findAccountBySign(String sign){
        return accountRepository.findByWeixinbindsign(sign);
    }
}
