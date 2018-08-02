package com.gyq.pattern.observer;

/**
 * 观察者（订阅者）.
 *
 * @author gaoyaqiu
 * @date 2018/8/2
 */
public abstract class Observer {

    /**
     * 有状态改变时，更新数据
     */
    public abstract void update();
}
