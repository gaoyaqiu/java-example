package com.gyq.learning.functional;

import java.util.function.Consumer;

/**
 * @author gaoyaqiu
 * @date 2019/2/21
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer consumer = System.out::println;

        Consumer<String> consumer2 = ConsumerDemo::echo;
        consumer2.accept("hi");

        consumer2.andThen(consumer);

    }

    private static void echo(String message) {
        System.out.println(message);
    }
}
