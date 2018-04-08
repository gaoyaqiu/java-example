package com.gyq.pattern.strategy;

/**
 * @auther gaoyaqiu
 */
public class MerchatDiscount implements DiscountStrategy {
    @Override
    public double getDiscount(double originPrice) {
        System.out.println("使用商户打折...");
        return originPrice * 0.8;
    }
}
