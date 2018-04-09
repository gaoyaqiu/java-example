package com.gyq.jdk.java8.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @auther gaoyaqiu
 */
public final class CollectionTest {

    @Test
    public void test1() {
        List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu", "maliu");

        // 将流转换为List
        List<String> list1 = list.stream().collect(toList());
        System.out.println(list1);

        List<String> list2 = list.stream().parallel().sorted(Comparator.comparing(String::toLowerCase)).collect(toList());
        System.out.println(list2);

        List<String> list3 = list.stream().filter(x -> !x.equals("lisi")).collect(toList());
        System.out.println(list3);

        list.stream().map(String::toUpperCase).forEach(System.out::println);

        String str = list.stream().collect(Collectors.joining(","));
        System.out.println(str);

        Map<String, String> map = list.stream().collect(Collectors.toMap(x -> x, x -> x));
        System.out.println("-------------");
        System.out.println(map);
        System.out.println("-------------");


        list.forEach(x -> System.out.println(x));
        System.out.println("-------------");
        list.forEach(System.out::println);


        System.out.println("-------------");
        // 一个参数
        BinaryOperator<String> operator = BinaryOperator.maxBy((x, y) -> x.compareTo(y));
        Optional<String> max = list.stream().reduce(operator);
        System.out.println(max);

        System.out.println("-------------");
        // 两个参数
        Optional<String> max2 = list.stream().reduce((x, y) -> x + y);
        System.out.println(max2);

        // 三个参数
        System.out.println("-------------");
        StringBuilder joining = list.stream()
                .reduce(new StringBuilder(),
                        (x, y) -> x.append(y).append(","),
                        (a, b) -> a.append(b));
        System.out.println(joining);
    }

    @Test
    public void test2() {
        List<User> list = Arrays.asList(new User("zhagsan", 18), new User("lisi", 28), new User("wangwu", 5));

        list.stream().map(x -> new User(x.getName(), x.getAge())).collect(toList()).forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println("k:" + user.getName() + "--v:" + user.getAge());
            }
        });
        System.out.println("-------------");

        List<String> list1 = list.stream().map(User::getName).collect(toList());
        System.out.println(list1);
        System.out.println("-------------");
        List<User> list2 = list.stream().map(x -> new User(x.getName(), x.getAge())).collect(toList());
        System.out.println(list2);
        System.out.println("-------------");

        Set<String> set = list.stream().map(User::getName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);

        System.out.println("-------------");

        String joined = list.stream().map(User::getName).collect(Collectors.joining(","));
        System.out.println(joined);
        System.out.println("-------------");

        int total = list.stream().collect(Collectors.summingInt(User::getAge));
        System.out.println(total);
        System.out.println("-------------");

        Map<Integer, List<User>> map = list.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(map);
        System.out.println("-------------");

        Map<String, Integer> map2 = list.stream().collect(Collectors.groupingBy(User::getName, Collectors.summingInt(User::getAge)));
        System.out.println(map2);

        System.out.println("-------------");


    }

    @Getter
    @Setter
    @AllArgsConstructor
    class User {
        private String name;

        private int age;
    }
}
