package org.learn.points.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.learn.points.entity.Points;

public interface PointsService extends IService<Points> {

    public void increase(String username, Integer points);
}
