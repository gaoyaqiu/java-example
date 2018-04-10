package com.gyq.jdk.java8.methodreference;

import org.junit.Test;

/**
 * @auther gaoyaqiu
 */
public final class BookTest {

    @Test
    public void test() {
        // 引用构造方法
        Message message = Book::new;
        // class com.gyq.jdk.java8.methodreference.BookTest$$Lambda$1/116211441
        System.out.println(message.getClass());
        // 调用构造方法的方法体
        message.getInfo();
    }
}
