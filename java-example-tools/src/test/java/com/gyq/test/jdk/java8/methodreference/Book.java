package com.gyq.test.jdk.java8.methodreference;

/**
 * 方法引用练习.
 *
 * @auther gaoyaqiu
 */
public class Book {
    public Book() {
        System.out.println("hello world!");
    }
}

@FunctionalInterface
interface Message {
    void getInfo();
}
