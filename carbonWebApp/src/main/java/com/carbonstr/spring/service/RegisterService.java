package com.carbonstr.spring.service;

import com.carbonstr.spring.model.Account;

public interface RegisterService {

    public void registerAccount(Account a);
    public void changePassword(Account a, String newPassword);
    public void deleteAccount(Account a);

}
