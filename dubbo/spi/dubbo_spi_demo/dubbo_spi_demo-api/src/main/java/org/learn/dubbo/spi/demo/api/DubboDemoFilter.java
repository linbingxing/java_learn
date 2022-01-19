package org.learn.dubbo.spi.demo.api;

import org.apache.dubbo.rpc.*;

/**
  * @description dubbo过滤器
  * @author lbx
  * @date 2022/1/19 10:41
  * @version 1.0.0
 **/
public class DubboDemoFilter implements Filter {


    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        return null;
    }
}
