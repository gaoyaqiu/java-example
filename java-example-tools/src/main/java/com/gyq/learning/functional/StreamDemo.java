package com.gyq.learning.functional;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author gaoyaqiu
 * @date 2019/2/22
 */
public class StreamDemo {

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        count(numbers);

        line();

        filter(numbers);

        line();

        sort(4, 9, 8, 3, 1, 7, 5, 2, 6);

        line();
        // 反向操作
        sort((x, y) -> (x < y) ? 1 : ((x == y) ? 0 : -1),
                4, 9, 8, 3, 1, 7, 5, 2, 6);

        line();

        // 并行
        parallelSort(numbers);

        line();

        isParallel(numbers);

    }

    private static void isParallel(Integer... numbers) {
        Stream<Integer> stream = Stream.of(numbers);
//        stream.parallel();
        // 如果对方写的方法，Stream作为参数的话，第一个操作就需要判断它是不是并行的，如果你的业务数据之间有依赖关系，那么需要
        // 将并行切换为串行，减少业务上的损耗 stream.sequential();
        System.out.println(stream.isParallel());
    }


    private static void parallelSort(Integer... numbers) {
        Stream.of(numbers)
                .sorted()
                .parallel()
                .forEach(StreamDemo::println);
    }

    private static void println(Object object) {
        System.out.printf("[%s] : %s\n", Thread.currentThread().getName(), object);
    }

    private static void line() {
        System.out.println();
    }

    private static void count(Integer... numbers) {
        Stream.of(numbers)
                // 合并
                .reduce(Integer::sum)
                .map(String::valueOf)
                .ifPresent(System.out::println);
    }

    private static void filter(Integer... numbers) {
        Stream.of(numbers).filter(num -> num % 2 == 0).forEachOrdered(System.out::println);
    }

    private static void sort(Integer... numbers) {
        Stream.of(numbers).sorted().forEach(System.out::println);
    }

    private static void sort(Comparator<Integer> comparator, Integer... numbers) {
        Stream.of(numbers).sorted(comparator).forEach(System.out::println);
    }


}
