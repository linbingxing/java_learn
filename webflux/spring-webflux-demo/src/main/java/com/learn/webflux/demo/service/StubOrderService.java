package com.learn.webflux.demo.service;

import com.learn.webflux.demo.domain.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StubOrderService {

    private final Map<String, Order> orders = new ConcurrentHashMap<>();

    public Flux<Order> getOrders() {
        return Flux.fromIterable(this.orders.values());
    }

    public Flux<Order> getOrdersByIds(final Flux<String> ids) {
        return ids.flatMap(id -> Mono.justOrEmpty(this.orders.get(id)));
    }

    public Mono<Order> getOrdersById(final String id) {
        return Mono.justOrEmpty(this.orders.get(id));
    }

    public Mono<Void> createOrUpdateOrder(final Mono<Order> productMono) {
        return productMono.doOnNext(product -> {
            orders.put(product.getId(), product);
        }).thenEmpty(Mono.empty());
    }

    public Mono<Order> deleteOrder(final String id) {
        return Mono.justOrEmpty(this.orders.remove(id));
    }

}
