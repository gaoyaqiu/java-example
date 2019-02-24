package com.gyq.learning.functional;

import java.util.function.Supplier;

/**
 * @author gaoyaqiu
 * @date 2019/2/21
 */
public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Long> supplier = getLong();
    }

    public static Supplier<Long> getLong() {
//        return () -> {
//            return System.currentTimeMillis();
//        };

        return System::currentTimeMillis;
    }
}
