package com.learn.webflux.demo.controller;

import com.learn.webflux.demo.domain.Order;
import com.learn.webflux.demo.service.StubOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orders")

public class StubOrderController {


    @Resource
    private StubOrderService orderService;


    @GetMapping("")
    public Flux<Order> getOrders() {
        return this.orderService.getOrders();
    }


    @GetMapping("/{id}")
    public Mono<Order> getOrderById(@PathVariable("id") final String id) {
        return this.orderService.getOrdersById(id);
    }


    @PostMapping("")
    public Mono<Void> createOrder(@RequestBody final Mono<Order> order) {
        return this.orderService.createOrUpdateOrder(order);
    }

    @DeleteMapping("/{id}")
    public Mono<Order> delete(@PathVariable("id") final String id) {
        return this.orderService.deleteOrder(id);
    }

}
