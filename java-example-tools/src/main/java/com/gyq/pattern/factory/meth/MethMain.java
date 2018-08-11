package com.gyq.pattern.factory.meth;

/**
 * 工厂方法模式（创建型设计模式）.
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class MethMain {

    public static void main(String[] args) {
        MethFactory factory = new BenzFactory();
        factory.getCar().getName();
    }
}
