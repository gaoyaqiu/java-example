package com.gyq.base.string;

/**
 * 将字符串进行反转.
 *
 * @author gaoyaqiu
 */
public class StringReverseExample {

    public static void main(String[] args) {

        String source = " hello world! ";
        // String result = reverse1(source, 0, source.length() - 1);
        String result = reverse2(source, 0, source.length() - 1);
        System.out.println(result);
    }

    public static String reverse1(String str, int start, int end) {
        char[] chars = str.toCharArray();
        return reverseArray(chars, start, end);
    }

    private static String reverseArray(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            // 交换前后字符
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);
    }

    public static String reverse2(String str, int start, int end) {
        String str1 = str.substring(0, start);
        StringBuilder sb = new StringBuilder();
        // 先将start之前的字符保存起来
        sb.append(str1);
        for (int i = end; i >= start; i--) {
            char c = str.charAt(i);
            // 保存中间的字符
            sb.append(c);
        }
        // 保存剩下的字符
        sb.append(str.substring(end + 1));
        return sb.toString();
    }
}
