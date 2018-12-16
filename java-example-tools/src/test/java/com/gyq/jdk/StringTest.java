package com.gyq.jdk;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;

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

    @Test
    public void assertIndexOf() {
        String str1 = "abcdefg";

        System.out.println(str1.indexOf("e"));

    }

    @Test
    public void assertLastIndexOf() {
        String str1 = "1233";

        System.out.println(str1.lastIndexOf("2"));
        System.out.println(str1.lastIndexOf("23"));
        System.out.println(str1.lastIndexOf("3"));
    }

    @Test
    public void assertStartsWith() {
        String str1 = "abcdefg";

        System.out.println(str1.startsWith("b"));
        System.out.println(str1.startsWith("ab"));
    }

    @Test
    public void assertEndsWith() {
        String str1 = "abcdefg";

        System.out.println(str1.endsWith("g"));
        System.out.println(str1.endsWith("fg"));
        System.out.println(str1.endsWith("ab"));
    }

    @Test
    public void assertRegionMatches() {
        String source = "abcdefg";
        String target = "fg";

        System.out.println(source.regionMatches(5, target, 0, target.length()));
        System.out.println(source.regionMatches(4, target, 0, target.length()));
    }

    @Test
    public void assertSubstring() {
        String source = "abcdefg";

        System.out.println(source.substring(0));
        System.out.println(source.substring(1));
        System.out.println(source);
    }

    @Test
    public void assertReplace() {
        String source = "abcdefgfg";
        String newStr = "hello";

        System.out.println(source.replace("fg", newStr));
    }

    @Test
    public void assertReplaceAll() {
        String source = "abcdefgfg";
        String newStr = "hello";

        System.out.println(source.replaceAll("fg", newStr));


        source = "ab$cdefgfg";
        System.out.println(source.replaceAll("$", newStr));
        System.out.println(source.replaceAll(Matcher.quoteReplacement("$"), newStr));
    }

    @Test
    public void assertConcat() {
        String source = "abcdefgfg";

        System.out.println(source.concat("123"));

    }

    @Test
    public void assertSplit() {
        String source = "ab,cdef,gfg,";

        String[] str = source.split(",");

        System.out.println(Arrays.toString(str));
    }

    @Test
    public void assertStringConvert1() {
        String source = "123";
        // 字符串转换为基本数据类型、包装类
        int result = Integer.parseInt(source);
        System.out.println(result);

        // 基本数据类型、包装类转换为字符串
        String str = String.valueOf(result);
        System.out.println(str);
    }

    @Test
    public void assertStringConvert2() {
        String source = "123abc";
        // 字符串转与字节数组转换(不支持中文)
        byte[] bytes = source.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println((char)bytes[i]);
        }
        System.out.println("==================");

        // 字节数组转换为字符串
        String str = new String(bytes);
        System.out.println(str);
    }

    @Test
    public void assertStringConvert3() {
        String source = "123abc张三炮";
        // 字符串转与字符数组转换(支持中文)
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        System.out.println("==================");

        // 字符数组转换为字符串
        String str = new String(chars);
        System.out.println(str);
    }
}
