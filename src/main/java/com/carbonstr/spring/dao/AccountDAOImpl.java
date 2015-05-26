package com.carbonstr.spring.dao;

import com.carbonstr.spring.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AccountDAOImpl implements AccountDAO {

    private static final Logger logger = LoggerFactory.getLogger(AccountDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addAccount(Account a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(a);
        logger.info("account created");
    }

    @Override
    public void updateAccount(Account a) {

    }

    @Override
    public void removeAccount(Account a) {

    }

    @Override
    public Account getAccount(String name, String password) {
        return null;
    }
}
