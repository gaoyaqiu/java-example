package com.gyq.learning.functional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author gaoyaqiu
 * @date 2019/2/24
 */
public class StreamCollectDemo {

    public static void main(String[] args) {
        List<Integer> values = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toList ());

        System.out.println(values.getClass());

        values = Stream.of(1, 2, 3, 4, 5)
                .collect(LinkedList::new, List::add, List::addAll);

        System.out.println(values.getClass());

    }

}
