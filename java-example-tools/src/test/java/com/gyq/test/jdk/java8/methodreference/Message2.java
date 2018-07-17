package com.gyq.test.jdk.java8.methodreference;

/**
 * 函数式接口.
 *
 * @param <P> 参数类型
 * @param <R> 返回值类型
 * @auther gaoyaqiu
 */
@FunctionalInterface
public interface Message2<P, R> {

    R getInfo(P p);
}
