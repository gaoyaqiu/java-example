package com.gyq.base.object;


/**
 * @author gaoyaqiu
 * @date 2018/8/5
 */
public class Car implements Cloneable {

    private BMW bmw;

    public Car(BMW bmw) {
        this.bmw = bmw;
    }

    public BMW getBmw() {
        return bmw;
    }

    public void setBmw(BMW bmw) {
        this.bmw = bmw;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Car car = (Car) super.clone();
        car.bmw = (BMW) bmw.clone();
        return car;
    }
}

