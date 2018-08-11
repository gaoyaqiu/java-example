package com.gyq.pattern.factory.abst;

/**
 * 抽象工厂模式（创建型设计模式）.
 *
 * 特点：创建整个产品族，而不是单一产品。通过选择不同的工厂来生产不同的汽车
 * 优点：客户端和具体要创建的产品解耦，扩展性和灵性性较高
 * 缺点：当要创建新的工厂时候，增加的代码较多，使系统变得复杂
 *
 * 总结：设计模式目的之一是让代码具有可扩展性，如果new对象这一块的业务未来需要扩展，或者有可能扩展，则可以使用工厂模式。使用
 * 简单工厂还是抽象工厂还得具体情况具体分析（简单工厂用的较多）
 * 建议：有简单的方法就不要用复杂的方法，要灵活使用设计模式，不要被条条框框给限制住
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class AbstMain {
    public static void main(String[] args) {
        AbstractCarFactory abstractCarFactory = new CarSale();
        abstractCarFactory.getAlto().getName();
    }
}
