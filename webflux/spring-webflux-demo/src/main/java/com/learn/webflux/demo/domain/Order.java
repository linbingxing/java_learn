package com.learn.webflux.demo.domain;

import lombok.Data;

@Data
public class Order {

    private String id;
    private String orderNumber;
    private String deliveryAddress;
    private String goods;
}
