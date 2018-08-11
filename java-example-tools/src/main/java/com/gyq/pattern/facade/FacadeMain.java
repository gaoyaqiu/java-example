package com.gyq.pattern.facade;

/**
 * 外观模式（结构型设计模式）体现了"迪米特法则"最少知道原则的精髓.类与类之间减少耦合，越独立越好。有句话叫牵一发而动全身，如果类之间关系太紧密，
 * 与之关联的类太多，一旦你修改该类，也许会动到无数与之关联的类，到时就炸锅了
 * <p>
 * 特点: 包装多个复杂的子系统(隐藏不想暴露的接口)，对外只提供一个简单的接口
 * 优缺点: 将复杂的接口简单化，减少客户端与接口之间的耦合，提供系统的安全性。不过可能会产生大量的中间类(外观类)，一定程序上
 * 增加了系统的复杂度。
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class FacadeMain {

    public static void main(String[] args) {
        new StartFacade().start();
    }
}
