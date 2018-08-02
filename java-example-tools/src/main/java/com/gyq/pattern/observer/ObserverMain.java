package com.gyq.pattern.observer;

/**
 * 观察者模式.
 *
 * 特点: 有两个角色(观察者和被观察者)，被观察者中存了一份所有观察者列表，当被观察者状态改变就通知观察者
 * 优点: 观察者和被观察者之间解耦，被观察者无需知道通知的对象是谁
 * 缺点: 如果观察者较多，通知较耗时(可能需要采用多线程方式来处理)
 *
 * 案例：如果没有特殊业务可以使用JDK提供的Observable即可，没必要自己实现，同时也考虑到了线程安全问题，
 * 不过Observable是一个类，并不是接口需要注意下。
 * @author gaoyaqiu
 * @date 2018/8/2
 */
public class ObserverMain {

    public static void main(String[] args) {
        ISubject subject = new WebSiteRSS();

        Observer customerA = new CustomerA("张三");
        Observer customerB = new CustomerB("李四");

        subject.registerObserver(customerA);
        subject.registerObserver(customerB);

        subject.notifyObserver();

    }
}
