package com.gyq.pattern.strategy;

/**
 * 优点： 策略模式定义了不同折扣方式，分别封装起来，当有其它的折扣方式时，不需要修改源码，只需要新增一个类（满足开闭原则）.
 * 缺点: 随着策略的增加，类会越来越多.
 *
 * 案例：使用过shiro的童鞋，都知道在shiro中可以创建多个权限验证器进行权限验证，shiro为我们提供了三种验证策略AtLeastOneSuccessfulStrategy、FirstSuccessfulStrategy、
 * AllSucessfulStrategy，如果这三种策略不符合咱们的需求，咱们可以自定义一个MyAuthenticationStrategy策略继承 shiro 的 AbstractAuthenticationStrategy类来实现具体的验证规则。
 *
 * @author gaoyaqiu
 */
public class StrategyMain {
    public static void main(String[] args) {
        DiscountContext context = new DiscountContext(null);
        System.out.println(context.getDiscountPrice(10));

        context = new DiscountContext(new VipDiscount());
        System.out.println(context.getDiscountPrice(10));
    }
}
