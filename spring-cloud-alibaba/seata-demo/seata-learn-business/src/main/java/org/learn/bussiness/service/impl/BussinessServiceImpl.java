package org.learn.bussiness.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import org.learn.bussiness.feign.OrderServiceFeign;
import org.learn.bussiness.feign.PointsServiceFeign;
import org.learn.bussiness.feign.StorageServiceFeign;
import org.learn.bussiness.service.IBussinessService;
import org.learn.bussiness.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BussinessServiceImpl implements IBussinessService {

    @Autowired
    OrderServiceFeign orderServiceFeign;
    @Autowired
    PointsServiceFeign pointsServiceFeign;

    @Autowired
    StorageServiceFeign storageServiceFeign;

    @Autowired
    IdWorker idWorker;

    /**
     * 商品销售
     *
     * @param goodsId  商品id
     * @param num      销售数量
     * @param username 用户名
     * @param money    金额
     */
//    @Transactional
    @GlobalTransactional(name = "sale", timeoutMills = 100000, rollbackFor =
            Exception.class)
    public void sale(Integer goodsId, Integer num, Double money, String username) {
        //创建订单
        orderServiceFeign.addOrder(idWorker.nextId(), goodsId, num, money, username);
        //增加积分
        pointsServiceFeign.increase(username, (int) (money / 10));
        //扣减库存
        storageServiceFeign.decrease(goodsId, num);
    }
}
