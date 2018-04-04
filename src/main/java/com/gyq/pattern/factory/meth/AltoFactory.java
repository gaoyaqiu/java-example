package com.gyq.pattern.factory.meth;

import com.gyq.pattern.factory.Alto;
import com.gyq.pattern.factory.Car;

/**
 * @auther gaoyaqiu
 */
public class AltoFactory implements MethFactory {
    @Override
    public Car getCar() {
        return new Alto();
    }
}
