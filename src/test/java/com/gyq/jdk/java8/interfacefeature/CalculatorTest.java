package com.gyq.jdk.java8.interfacefeature;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @auther gaoyaqiu
 */
public final class CalculatorTest {

    @Test
    public void test(){
        Calculator calculator = new CalculatorImpl();
        int a = calculator.add(1, 2);
        assertThat(a, is(3));

        int b = calculator.minus(3, 2);
        assertThat(b, is(1));

        Calculator.hi();
    }
}
