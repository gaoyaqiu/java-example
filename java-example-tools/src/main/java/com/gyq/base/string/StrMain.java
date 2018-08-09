package com.gyq.base.string;

/**
 * @author gaoyaqiu
 * @date 2018/8/9
 */
public class StrMain {

    public static void main(String[] args) {

        String s1 = "Hello World!";

        // 根据新的字符串构造一个新的String对象
        String s2 = new String("Hello World");
        System.out.println("s2 = " + s2);

        // 根据字符数组构造一个新的String对象
        String s3 = new String(new char[]{'h', 'e', 'l', 'l'});
        System.out.println("s3 = " + s3);

        // 根据部分字符数据构造一个新的String对象
        String s4 = new String(new char[]{'h', 'e', 'l', 'l'}, 0, 2);
        System.out.println("s4 = " + s4);

        // 根据字节数据构造一个新的String对象
        String s5 = new String(new byte[]{'h', 'e', 'l', 'l'});
        System.out.println("s5 = " + s5);
    }
}
