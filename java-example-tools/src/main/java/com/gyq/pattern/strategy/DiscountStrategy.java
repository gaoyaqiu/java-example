package com.gyq.pattern.strategy;

/**
 * 策略模式.
 *
 * @auther gaoyaqiu
 */
public interface DiscountStrategy {

    // 计算打折
    double getDiscount(double originPrice);
}
