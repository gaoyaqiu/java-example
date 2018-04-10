package com.gyq.jdk.java8.function;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 内建函数式接口.
 *
 * @auther gaoyaqiu
 */
public final class functionTest {

    @Test
    public void test(){
        // 功能型接口函数使用
        Function<String, Integer> fun = Integer::parseInt;
        // 接受输入数据,返回结果
        int num = fun.apply("200");
        System.out.println(num * 2);
        System.out.println("-------------------");

        // 消费型接口函数使用
        Consumer<String> consumer = System.out::println;
        // 接收数据, 没有返回值
        consumer.accept("Hello World!");
        System.out.println("-------------------");

        // 供给型接口函数使用
        Supplier<Long> supplier = System::currentTimeMillis;
        // 没有参数,但是可以返回数据
        System.out.println(supplier.get());
        System.out.println("-------------------");

        // 断言型接口函数使用
        String str = "100";
        Predicate<String> predicate = str::matches;
        System.out.println(predicate.test("\\d+"));
    }
}
