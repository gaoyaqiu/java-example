package com.gyq.pattern.factory.meth;

import com.gyq.pattern.factory.BMW;
import com.gyq.pattern.factory.Car;

/**
 * @auther gaoyaqiu
 */
public class BMWFactory implements MethFactory{
    @Override
    public Car getCar() {
        return new BMW();
    }
}
