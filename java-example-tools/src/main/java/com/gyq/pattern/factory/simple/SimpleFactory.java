package com.gyq.pattern.factory.simple;

import com.gyq.pattern.factory.Alto;
import com.gyq.pattern.factory.BMW;
import com.gyq.pattern.factory.Benz;
import com.gyq.pattern.factory.Car;

/**
 * 简单工厂模式.
 *
 * @auther gaoyaqiu
 */
public class SimpleFactory {

    public Car getCar(String name) {
        if ("BMW".equalsIgnoreCase(name)) {
            return new BMW();
        } else if ("Benz".equalsIgnoreCase(name)) {
            return new Benz();
        }else if ("Alto".equalsIgnoreCase(name)) {
            return new Alto();
        }else {
            System.out.println(String.format("抱歉，我还未学会生产[%s]这个技能", name));
            return null;
        }
    }
}
