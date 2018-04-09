package com.gyq.jdk.java8.interfacefeature;

/**
 * 接口的默认方法和静态方法.
 *
 * @auther gaoyaqiu
 */
public interface Calculator {

    // 定义默认方法
    default int add(int a, int b) {
        return a + b;
    }

    int minus(int a, int b);

    // 定义静态方法, 无法被实现
    static void hi(){
        System.out.println("static method hi()");
    }
}
