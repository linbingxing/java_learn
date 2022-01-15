package org.learn.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.learn.order.entity.Order;
import org.learn.order.mapper.OrderMapper;
import org.learn.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public void add(Order order) {
        order.setCreateTime(new Date());//设置订单创建时间
        this.save(order);//保存订单
    }
}
