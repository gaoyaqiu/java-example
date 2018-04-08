package com.gyq.pattern.strategy;

/**
 * 打折策略.
 *
 * @auther gaoyaqiu
 */
public interface DiscountStrategy {

    // 计算打折
    double getDiscount(double originPrice);
}
