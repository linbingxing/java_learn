package org.learn.order.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import org.learn.order.entity.Order;

@LocalTCC
public interface OrderService extends IService<Order> {
    /**
     * @TwoPhaseBusinessAction 描述⼆阶段提交
     * name: 为 tcc⽅法的 bean 名称，需要全局唯⼀，⼀般写⽅法名即可
     * commitMethod: Commit⽅法的⽅法名
     * rollbackMethod:Rollback⽅法的⽅法名
     * @BusinessActionContextParamete 该注解⽤来修饰 Try⽅法的⼊参，
     * 被修饰的⼊参可以在 Commit ⽅法和 Rollback ⽅法中通过
    BusinessActionContext 获取。
     */
    @TwoPhaseBusinessAction(name = "addTcc",
            commitMethod = "addCommit", rollbackMethod =
            "addRollBack")
    void add(@BusinessActionContextParameter(paramName = "order")
                     Order order);

    public boolean addCommit(BusinessActionContext context);

    public boolean addRollBack(BusinessActionContext context);
}
