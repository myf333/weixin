package com.myf.weixin.repository.impl;

import com.myf.weixin.entity.Account;
import org.springframework.data.repository.CrudRepository;
/**
 * Created by myf on 2016/5/6.
 */
public interface SpringJPAAccountRepository extends CrudRepository<Account,Long> {
    public Account findByWeixinbindsign(String sign);
}
