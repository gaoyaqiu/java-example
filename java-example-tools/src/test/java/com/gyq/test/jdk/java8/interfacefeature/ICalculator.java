package com.gyq.test.jdk.java8.interfacefeature;

/**
 * 接口的默认方法和静态方法(适合lanmbda编程的函数式接口).
 *
 * @auther gaoyaqiu
 */
@FunctionalInterface
public interface ICalculator {

    // 此方法不需要子类强制实现
    default int add(int a, int b) {
        return a + b;
    }

    int minus(int a, int b);

    // 定义静态方法, 无法被实现
    static void hi(){
        System.out.println("static method hi()");
    }
}
