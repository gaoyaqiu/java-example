package com.gyq.pattern.observer;

/**
 * 被观察者(发布者).
 *
 * @author gaoyaqiu
 * @date 2018/8/2
 */
public interface ISubject {

    /**
     * 添加观察者.
     *
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者.
     *
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObserver();
}
