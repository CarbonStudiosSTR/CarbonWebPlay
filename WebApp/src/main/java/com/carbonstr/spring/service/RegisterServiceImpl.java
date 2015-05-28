package com.carbonstr.spring.service;

import com.carbonstr.spring.dao.AccountDAO;
import com.carbonstr.spring.model.Account;
import org.springframework.transaction.annotation.Transactional;

public class RegisterServiceImpl implements RegisterService {


    private AccountDAO accountDAO;

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    @Transactional
    public void registerAccount(Account a) {
        accountDAO.addAccount(a);
    }

    @Override
    @Transactional
    public void changePassword(Account a, String newPassword) {

    }

    @Override
    @Transactional
    public void deleteAccount(Account a) {

    }
}
