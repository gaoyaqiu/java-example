package com.gyq.pattern.strategy;

/**
 * @auther gaoyaqiu
 */
public class DiscountContext {
    private DiscountStrategy strategy;

    public DiscountContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double getDiscountPrice(double price) {
        if (strategy == null) {
            // 默认使用商户折扣
            strategy = new MerchatDiscount();
        }

        return this.strategy.getDiscount(price);
    }
}
