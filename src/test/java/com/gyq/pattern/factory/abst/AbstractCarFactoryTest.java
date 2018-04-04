package com.gyq.pattern.factory.abst;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @auther gaoyaqiu
 */
public class AbstractCarFactoryTest {

    @Test
    public void acfTest() {
        AbstractCarFactory abstractCarFactory = new CarSale();
        assertThat(abstractCarFactory.getBenz().getName(), is("Benz"));
    }
}
