package com.gyq.learning.functional;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author gaoyaqiu
 * @date 2019/2/22
 */
public class PredicateDesignDemo {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Collection<Integer> even = filter(numbers, num -> num % 2 == 0);
        Collection<Integer> odd = filter(numbers, num -> num % 2 != 0);
        System.out.println(even);

        System.out.println(odd);

        // 用Stream实现
        Stream.of(1, 2, 3, 4, 5).filter(num -> num % 2 == 0).forEachOrdered(System.out::println);
    }

    private static <E> Collection<E> filter(Collection<E> source, Predicate<E> predicate) {
        List<E> copy = new ArrayList<E>(source);
        Iterator<E> iterator = copy.iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (!predicate.test(element)) {
                iterator.remove();
            }
        }

        return Collections.unmodifiableList(copy);

    }
}
