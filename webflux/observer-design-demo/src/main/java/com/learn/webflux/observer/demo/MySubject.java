package com.learn.webflux.observer.demo;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
  * @description TODO
  * @author lbx
  * @date 2021/12/28 9:15
  * @version 1.0.0
 **/
public class MySubject implements Subject {
    /**
     * 用于封装订阅了该主题的观察者
     * 线程安全的
     */
    private final Set<Observer> observers = new CopyOnWriteArraySet<>();


    @Override
    public void registerObserver(Observer observer) {
      this.observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
      this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        this.observers.forEach(t->t.observe(event));
    }
}
