package com.gyq.pattern.proxy;

/**
 * 代理模式特点:
 * 1. 必须有两个角色：执行者，被代理人.
 * 2. 对于被代理人来说，这事想做但是因为种种原因又没法自己做，那么就找代理.
 * 3. 代理人持有被代理人的引用.
 *
 * 目的：解耦，通过反射调用传入的方法
 *
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public interface Person {

    /**
     * 找房
     */
    void findHourse();
}
