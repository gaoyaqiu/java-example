package com.gyq.pattern.decorator;

/**
 * 装饰器超类(和被装饰的对象实现同一个接口Person).
 *
 * @author gaoyaqiu
 * @date 2018/7/30
 */
public abstract class FoodDecorator implements IPerson {

    protected IPerson person;

    public FoodDecorator(IPerson person) {
        this.person = person;
    }
}
