package com.gyq.test.jdk.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 数据流.
 *
 * @auther gaoyaqiu
 */
public final class StreamTest {

    @Test
    public void test() {
        Stream<String> stream = Stream.of("zhangsan", "lisi", "wangwu");
        stream.forEach(System.out::println);
        System.out.println("----------------------------------");
        List<String> list = Arrays.asList("java", "php", "python", "go", "java", "go");
        // 过滤数据
        list.stream().filter(x -> x.contains("h")).forEach(System.out::println);
        System.out.println("----------------------------------");
        // 将满足条件的集合变为新的集合
        list.stream().map(x -> x.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("----------------------------------");

        // 去重
        list.stream().map(x -> x.toUpperCase()).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("----------------------------------");

        // 判断集合中的全部数据是否都存在a
        if (list.stream().allMatch(s -> s.contains("a"))) {
            System.out.println("集合中的内容都包含有字母a!");
        }

        // 判断集合中的任意数据是否有a
        if (list.stream().anyMatch(s -> s.contains("a"))) {
            System.out.println("集合中的内容有部分数据包含字母a!");
        }

        // 判断集合中得全部数据是否都没有w
        if (list.stream().noneMatch(s -> s.contains("w"))) {
            System.out.println("集合中的内容都不包含字母w!");
        }

        System.out.println("----------------------------------");

        // 匹配多个判断条件
        Predicate<String> cond1 = s -> s.contains("a");
        Predicate<String> cond2 = s -> s.length() == 4;
        Predicate<String> cond3 = s -> s.contains("o");
        list.stream().filter(cond1.or(cond2).or(cond3)).forEach(System.out::println);

        System.out.println("----------------------------------");

        // 并行处理
        list.stream().parallel().forEach(System.out::println);

        System.out.println("----------------------------------");
        // 串行处理(默认),sequential可以省略
        list.stream().sequential().forEach(System.out::println);
        System.out.println("----------------------------------");
    }
}
