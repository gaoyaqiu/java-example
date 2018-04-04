package com.gyq.pattern.factory;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @auther gaoyaqiu
 */
public class SimpleFactoryTest {

    @Test
    public void sfTest() {
        String name = "Alto";

        Car car = new SimpleFactory().getCar(name);
        assertNotNull(car);
        assertThat(car.getName(), is(name));
    }
}
