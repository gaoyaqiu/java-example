package com.gyq.pattern.factory.meth;

import com.gyq.pattern.factory.Benz;
import com.gyq.pattern.factory.Car;

/**
 * @auther gaoyaqiu
 */
public class BenzFactory implements MethFactory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
