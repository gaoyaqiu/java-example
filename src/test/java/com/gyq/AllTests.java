package com.gyq;

import com.gyq.pattern.factory.abst.AbstractCarFactoryTest;
import com.gyq.pattern.factory.meth.MethFactoryTest;
import com.gyq.pattern.factory.simple.SimpleFactoryTest;
import com.gyq.pattern.singleton.SingletonTest;
import com.gyq.pattern.strategy.DiscountTest;
import com.gyq.jdk.java8.interfacefeature.CalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @auther gaoyaqiu
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        SingletonTest.class,
        DiscountTest.class,
        SimpleFactoryTest.class,
        MethFactoryTest.class,
        AbstractCarFactoryTest.class,
        CalculatorTest.class
})
public class AllTests {
}
