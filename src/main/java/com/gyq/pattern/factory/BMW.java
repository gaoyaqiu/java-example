package com.gyq.pattern.factory;

/**
 * @auther gaoyaqiu
 */
public class BMW implements Car {
    @Override
    public String getName() {
        System.out.println("开始生产" + BMW.class.getSimpleName());
        return "BMW";
    }
}
