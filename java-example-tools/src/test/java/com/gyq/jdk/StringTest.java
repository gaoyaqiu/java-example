package com.gyq.jdk;

import org.junit.Test;

/**
 * @author gaoyaqiu
 */
public final class StringTest {

    @Test
    public void assertLength() {
        String str1 = "abcdefg";

        System.out.println(str1.length());
    }

    @Test
    public void assertCharAt() {
        String str1 = "abcdefg";

        System.out.println(str1.charAt(0));
        System.out.println(str1.charAt(1));
        System.out.println(str1.charAt(18));
    }

    @Test
    public void assertEquals() {
        String str1 = "abcdefg";

        System.out.println(str1.equals("abcdefg"));
        System.out.println(str1.equals("aaa"));
    }

    @Test
    public void assertCompareTo() {
        String str1 = "abcdefg";

        System.out.println(str1.compareTo("abcdefg"));
        System.out.println(str1.compareTo("aa"));
        System.out.println(str1.compareTo("gg"));
        System.out.println(str1.compareTo("ABCDEF"));
    }
}
