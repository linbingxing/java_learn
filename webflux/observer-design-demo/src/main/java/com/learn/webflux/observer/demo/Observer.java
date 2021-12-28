package com.learn.webflux.observer.demo;

/**
  * @description TODO
  * @author lbx
  * @date 2021/12/28 9:14
  * @version 1.0.0
 **/
public interface Observer {

    /**
     * 让主题回调的方法，通知当前观察者事件
     * @param event 通知的事件
     */
    void observe(String event);

}
