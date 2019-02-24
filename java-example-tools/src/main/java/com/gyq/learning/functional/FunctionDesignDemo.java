package com.gyq.learning.functional;

import java.util.function.Function;

/**
 * @author gaoyaqiu
 * @date 2019/2/22
 */
public class FunctionDesignDemo {

    public static void main(String[] args) {

        Function function = a -> a;

        Function<Integer, Integer> divide2 = a -> a / 2;

    }


}
