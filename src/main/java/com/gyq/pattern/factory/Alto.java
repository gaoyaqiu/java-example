package com.gyq.pattern.factory;

/**
 * @auther gaoyaqiu
 */
public class Alto implements Car {
    @Override
    public String getName() {
        System.out.println("开始生产" + Alto.class.getSimpleName());
        return "Alto";
    }
}
