package com.gyq.pattern.strategy;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * 策略模式测试.
 *
 * @auther gaoyaqiu
 */
public class DiscountTest {


    @Test
    public void lazySingleton1Test() {
        DiscountContext context = new DiscountContext(null);
        Assert.assertThat(context.getDiscountPrice(10), is(8.0));

        context = new DiscountContext(new VipDiscount());
        Assert.assertThat(context.getDiscountPrice(10), is(5.0));
    }
}
