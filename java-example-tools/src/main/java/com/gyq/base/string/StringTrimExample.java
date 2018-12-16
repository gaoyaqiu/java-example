package com.gyq.base.string;

/**
 * 模拟一个trim方法,去除字符串两端空格.
 *
 * @author gaoyaqiu
 */
public class StringTrimExample {

    public static void main(String[] args) {

        String source = " hello world! ";
        String result = myTrim(source);
        System.out.println(result);
    }

    public static String myTrim(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (str.charAt(start) == ' ' && start < end) {
            // 从前往后判断, 找到不是空格的字符位置, 并且start小于end(防止数组越界)
            start++;
        }

        while (str.charAt(end) == ' ' && start < end) {
            // 从后往前判断, 找到不是空格的字符位置
            end--;
        }

        return str.substring(start, end + 1);
    }
}
