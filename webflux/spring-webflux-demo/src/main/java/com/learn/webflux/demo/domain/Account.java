package com.learn.webflux.demo.domain;

import lombok.Data;

@Data
public class Account {
    private Long id;
    private String accountCode;
    private String accountName;
}
