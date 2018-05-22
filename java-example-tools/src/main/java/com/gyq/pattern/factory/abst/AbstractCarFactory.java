package com.gyq.pattern.factory.abst;

import com.gyq.pattern.factory.Car;

/**
 * 抽象工厂.
 *
 * @auther gaoyaqiu
 */
public abstract class AbstractCarFactory {

    public abstract Car getBMW();

    public abstract Car getBenz();

    public abstract Car getAlto();

}
