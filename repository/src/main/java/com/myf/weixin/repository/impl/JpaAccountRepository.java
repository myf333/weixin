package com.myf.weixin.repository.impl;

import com.myf.weixin.entity.Account;
import com.myf.weixin.repository.core.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by myf on 2016/5/4.
 */
public class JpaAccountRepository implements AccountRepository {
    @Autowired
    private EntityManagerFactory emf;

    @Override
    public Account save(Account account) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
        em.close();
        return account;
    }

    @Override
    public Account findOne(long id) {
        EntityManager em = emf.createEntityManager();
        Account account = em.createQuery("select e from Account e where id=:id",Account.class).setParameter("id",id).getSingleResult();
        em.close();
        return account;
    }

    @Override
    public List<Account> list() {
        EntityManager em = emf.createEntityManager();
        List<Account> list = em.createQuery("from Account",Account.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public void update(Account account) {

    }
}
