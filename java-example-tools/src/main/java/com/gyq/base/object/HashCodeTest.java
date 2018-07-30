package com.gyq.base.object;

/**
 * @author gaoyaqiu
 * @date 2018/7/19
 */
public class HashCodeTest {

    public static void main(String[] args) {

        String s1 = "test";
        String s2 = "test";

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
