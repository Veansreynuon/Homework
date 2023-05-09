package com.student.demo_restfulapi.service;

import com.student.demo_restfulapi.model.Account;
import com.student.demo_restfulapi.model.UserAccount;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    int createAccount(Account account);
    int updateAccount(Account account, int id);
    Account findAccountByID(int id);

}
