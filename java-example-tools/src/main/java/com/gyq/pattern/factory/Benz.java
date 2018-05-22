package com.gyq.pattern.factory;

/**
 * @auther gaoyaqiu
 */
public class Benz implements Car {
    @Override
    public String getName() {
        System.out.println("开始生产" + Benz.class.getSimpleName());
        return "Benz";
    }
}
