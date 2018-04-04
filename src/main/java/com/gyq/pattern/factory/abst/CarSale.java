package com.gyq.pattern.factory.abst;

import com.gyq.pattern.factory.Car;
import com.gyq.pattern.factory.meth.AltoFactory;
import com.gyq.pattern.factory.meth.BMWFactory;
import com.gyq.pattern.factory.meth.BenzFactory;
import com.gyq.pattern.factory.meth.MethFactory;

/**
 * 汽车销售.
 *
 * @auther gaoyaqiu
 */
public class CarSale extends AbstractCarFactory {

    private MethFactory bmw = new BMWFactory();

    private MethFactory benz = new BenzFactory();

    private MethFactory alto = new AltoFactory();

    @Override
    public Car getBMW() {
        return bmw.getCar();
    }

    @Override
    public Car getBenz() {
        return benz.getCar();
    }

    @Override
    public Car getAlto() {
        return alto.getCar();
    }
}
