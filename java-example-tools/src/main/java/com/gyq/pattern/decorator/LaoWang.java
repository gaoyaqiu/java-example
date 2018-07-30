package com.gyq.pattern.decorator;

/**
 * @author gaoyaqiu
 * @date 2018/7/30
 */
public class LaoWang implements IPerson {

    @Override
    public double cost() {
        return 0.0;
    }

    @Override
    public void show() {
        System.out.println("老王准备去买菜...");
    }
}
