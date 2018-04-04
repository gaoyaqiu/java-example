package com.gyq.pattern.factory.meth;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @auther gaoyaqiu
 */
public class MethFactoryTest {

    @Test
    public void mfTest() {
        MethFactory factory = new BenzFactory();
        assertThat(factory.getCar().getName(), is("Benz"));
    }
}
