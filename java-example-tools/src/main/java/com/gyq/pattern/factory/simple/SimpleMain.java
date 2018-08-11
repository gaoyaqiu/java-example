package com.gyq.pattern.factory.simple;

/**
 * 简单工厂模式（创建型设计模式）.
 *
 * 特点：用于创建单一产品，创建过程集中在一个工厂中
 * 缺点: 当要生产新的汽车类型，需要修改工厂代码，违背了开闭原则
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class SimpleMain {

    public static void main(String[] args) {
        String name = "Alto";

        new SimpleFactory().getCar(name);
    }
}
