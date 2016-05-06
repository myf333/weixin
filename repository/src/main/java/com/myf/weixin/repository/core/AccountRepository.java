package com.myf.weixin.repository.core;

import com.myf.weixin.entity.Account;

import java.util.List;

/**
 * Created by myf on 2016/5/4.
 */
public interface AccountRepository {
    public Account save(Account account);

    public Account findOne(long id);

    public List<Account> list();

    public void remove(long id);

    public void update(Account account);
}
