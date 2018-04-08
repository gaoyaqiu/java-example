package com.gyq.pattern.strategy;

/**
 * @auther gaoyaqiu
 */
public class VipDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double originPrice) {
        System.out.println("使用VIP打折...");
        return originPrice * 0.5;
    }
}
