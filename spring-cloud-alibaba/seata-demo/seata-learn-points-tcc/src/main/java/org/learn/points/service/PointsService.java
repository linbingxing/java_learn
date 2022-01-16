package org.learn.points.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import org.learn.points.entity.Points;

@LocalTCC
public interface PointsService extends IService<Points> {

    @TwoPhaseBusinessAction(name = "increaseTcc", commitMethod =
            "increaseCommit"
            , rollbackMethod = "increaseRollback")
    public void increase(@BusinessActionContextParameter(paramName =
            "username")String username,
                         @BusinessActionContextParameter(paramName =
                                 "points")Integer points);
    public boolean increaseCommit(BusinessActionContext context);
    public boolean increaseRollback(BusinessActionContext context);
}
