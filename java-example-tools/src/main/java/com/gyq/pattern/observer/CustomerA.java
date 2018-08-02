package com.gyq.pattern.observer;

/**
 * @author gaoyaqiu
 * @date 2018/8/2
 */
public class CustomerA extends Observer {

    private String name;

    public CustomerA(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("我是客户: " + this.name + "，我收到订阅消息了");
    }
}
