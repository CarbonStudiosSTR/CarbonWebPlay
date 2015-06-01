package com.carbonstr.spring.dao;

import com.carbonstr.spring.model.Account;

public interface AccountDAO {

    public void addAccount(Account a);
    public void addAccountRole(Account a, String s);
    public void updateAccount(Account a);
    public void removeAccount(Account a);
    public Account getAccount(String name, String password);

}
