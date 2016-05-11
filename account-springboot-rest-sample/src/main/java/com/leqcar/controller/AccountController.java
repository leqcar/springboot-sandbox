package com.leqcar.controller;

import com.leqcar.domain.Account;
import com.leqcar.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by jongtenerife on 11/05/2016.
 */
@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(path = "/accounts/{accountNumber}", method = RequestMethod.GET)
    public Account accountNumber(@PathVariable String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @RequestMapping("/accounts")
    public Collection<Account> accounts() {
        return accountRepository.findAll();
    }
}
