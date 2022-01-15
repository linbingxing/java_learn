package org.learn.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.learn.storage.entity.Storage;

/**
 * 仓库服务
 */
public interface StorageService extends IService<Storage> {

    public void decrease(Integer goodsCode, Integer quantity);
}
