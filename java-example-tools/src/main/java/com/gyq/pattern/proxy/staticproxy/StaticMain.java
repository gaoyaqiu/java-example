package com.gyq.pattern.proxy.staticproxy;

/**
 * 静态代理(李四想买房，不是自己去找房源，而是通过中介手里买房).
 * <p>
 * 缺点: 如果系统中很多地方用到代理，需要写很多代理类.
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class StaticMain {

    public static void main(String[] args) {
        new AgencyProxy(new LiSi()).findHourse();
    }
}
