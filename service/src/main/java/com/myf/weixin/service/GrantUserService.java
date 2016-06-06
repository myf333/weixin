package com.myf.weixin.service;

import com.myf.weixin.entity.GrantUser;
import com.myf.weixin.repository.impl.GrantUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by myf on 2016/6/6.
 */
public class GrantUserService {
    @Autowired
    private GrantUserRepository repository;

    @Transactional
    public GrantUser addGrantUser(GrantUser user){
        return repository.save(user);
    }

    @Transactional
    public GrantUser updateGrantUser(GrantUser user){
        return repository.save(user);
    }

    public GrantUser findByOpenId(String openId){
        return repository.findOne(openId);
    }
}
