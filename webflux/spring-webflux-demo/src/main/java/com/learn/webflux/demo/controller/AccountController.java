package com.learn.webflux.demo.controller;

import com.learn.webflux.demo.domain.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/accounts")
    public Flux<Account> getAccountList() {
        Flux<Account> accounts = this.getAccounts();
        return accounts;
    }

    @GetMapping("/accounts/{id}")
    public Mono<Account> getAccountById(@PathVariable Long id) {
        Mono<Account> account = this.getAccountById1(id);
        return account;
    }


    private Flux<Account> getAccounts() {
        List<Account> accountList = new ArrayList<>();
        Account account = new Account();
        account.setId(1L);
        account.setAccountCode("DemoCode");
        account.setAccountName("DemoName");
        accountList.add(account);
        return Flux.fromIterable(accountList);
    }

    private Mono<Account> getAccountById1(Long id) {
        Account account = new Account();
        account.setId(id);
        account.setAccountCode("DemoCode");
        account.setAccountName("DemoName");
        return Mono.just(account);
    }

}
