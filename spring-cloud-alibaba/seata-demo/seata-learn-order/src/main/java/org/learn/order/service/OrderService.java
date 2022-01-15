package org.learn.order.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.learn.order.entity.Order;

public interface OrderService extends IService<Order> {
    void add(Order order);
}
