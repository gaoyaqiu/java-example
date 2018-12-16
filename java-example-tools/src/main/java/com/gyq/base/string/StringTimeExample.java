package com.gyq.base.string;

/**
 * 获取一个字符串在另一个字符串中出现的次数.
 *
 * @author gaoyaqiu
 */
public class StringTimeExample {

    public static void main(String[] args) {

        String source = "hello world hello abc";
        String str = "ll";
        System.out.println(getTime(source, str));
    }

    private static int getTime(String source, String str) {
        // 记录出现的次数
        int count = 0;
        // 首次出现的位置
        int index;
        while ((index = source.indexOf(str)) != -1) {
            // 找到一次就记录一次次数
            count++;
            // 从找到的位置开始，继续往后查询
            source = source.substring(index + str.length());
        }

        return count;
    }

}
