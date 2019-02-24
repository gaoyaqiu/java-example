package com.gyq.learning.functional;

import java.util.function.Supplier;

/**
 * @author gaoyaqiu
 * @date 2019/2/21
 */
public class SupplierDesignDemo {

    public static void main(String[] args) {
        // 固定参数
        echo("Hello World---1");

        // 变化实现，比较弹性的设计
        echo(() -> {
            sleep(1000);
            return "Hello World----2";
        });

        echo(SupplierDesignDemo::getMessage);

        // 及时返回数据
        System.out.println(getMessage());

        // 待执行数据
        Supplier<String> message = supplierMessage();
        // 开始执行
        System.out.println(message.get());

    }

    private static Supplier<String> supplierMessage() {
        return SupplierDesignDemo::getMessage;
    }

    private static String getMessage() {
        sleep(1000);
        return "Hello World----3";
    }


    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这种方式比较呆板.
     *
     * @param message
     */
    public static void echo(String message) {
        System.out.println(message);
    }

    /**
     * 这种方式比较灵活.
     *
     * @param message
     */
    public static void echo(Supplier<String> message) {
        System.out.println(message.get());
    }
}
