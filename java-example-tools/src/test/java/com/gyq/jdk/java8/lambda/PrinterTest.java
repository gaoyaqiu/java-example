package com.gyq.jdk.java8.lambda;

import org.junit.Test;

/**
 * @auther gaoyaqiu
 */
public final class PrinterTest {

    @Test
    public void testInnerClass() {
        String str = "hello world!";

        hi(new IPrinter() {
            @Override
            public void print() {
                // jdk7会报错，要求str为final，jdk8则不会报错，建议还是加上final
                System.out.println("[1]---" + str);
            }
        });


        hi(str, new IPrinterArg() {
            @Override
            public void printStr(String a) {
                System.out.println("[2]---" + a);
            }
        });

        String result = getStr(new IPrinterReturn() {
            @Override
            public String getStr() {
                return String.valueOf(System.currentTimeMillis());
            }
        });

        System.out.println("[3]---" + result);

        result = getStr(str, new IPrinterArgReturn() {
            @Override
            public String getStr(String a) {
                return a;
            }
        });

        System.out.println("[4]---" + result);

    }

    @Test
    public void testLambda() {
        hi(() -> System.out.println("[1]---hi lambda"));

        hi("world!", x -> System.out.println("[2]---hello " + x));

        String result = getStr(() -> {
            return String.valueOf(System.currentTimeMillis());
        });
        System.out.println("[3]---" + result);

        // 省略大括号，简化lambda写法
        result = getStr(() -> String.valueOf(System.currentTimeMillis()));
        System.out.println("[4]---" + result);


        result = getStr("world!", x -> "hello " + x);
        System.out.println("[5]---" + result);
    }


    private void hi(IPrinter p) {
        p.print();
    }

    private void hi(String str, IPrinterArg p) {
        p.printStr(str);
    }

    private String getStr(IPrinterReturn p) {
        return p.getStr();
    }

    private String getStr(String str, IPrinterArgReturn p) {
        return p.getStr(str);
    }
}
