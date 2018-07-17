package com.gyq.test.jdk.java8.methodreference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @auther gaoyaqiu
 */
public final class Message2Test {

    @Test
    public void test() {
        // 引用静态方法
        Message2<Integer, String> message2 = String::valueOf;
        System.out.println(message2.getInfo(10000));
        System.out.println(message2.getInfo(10000).length());

        // 引用普通方法
        String str = "**tssbook";
        Message2<String, Boolean> message3 = str::startsWith;
        System.out.println(message3.getInfo("*"));

        // 特定类型的方法引用
        String[] data = {"zhangsan", "lisi", "wangwu"};
        Comparator<String> comparator = String::compareToIgnoreCase;
        Arrays.sort(data, comparator);

        System.out.println(Arrays.toString(data));

        // 构造方法引用
        Creator<Book> creator = Book::new;
        System.out.println(creator.create("java", 60.3));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Book {
        private String title;
        private double price;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"title\":\"")
                    .append(title).append('\"');
            sb.append(",\"price\":")
                    .append(price);
            sb.append('}');
            return sb.toString();
        }
    }

    @FunctionalInterface
    interface Creator<R extends Book> {
        R create(String title, double price);
    }
}
