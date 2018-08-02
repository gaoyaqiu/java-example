package com.gyq.pattern.observer;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * 网站更新RSS订阅内容.
 *
 * @author gaoyaqiu
 * @date 2018/8/2
 */
public class WebSiteRSS implements ISubject {

    private List<Observer> observers = newArrayList();

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        System.out.println("网站更新了RSS内容");
        this.observers.forEach(item -> item.update());
    }
}
