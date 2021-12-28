package com.learn.webflux.observer.demo;

/**
  * @description TODO
  * @author lbx
  * @date 2021/12/28 9:20
  * @version 1.0.0
 **/
public class MyObserver2 implements Observer {

    @Override
    public void observe(String event) {
        System.out.println("观察者2 -- " + event);
    }
}
