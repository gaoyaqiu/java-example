package com.gyq.test.jdk.base.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author gaoyaqiu
 * @date 2019/3/10
 */
public class IteratorTest {

    @Test
    public void testRemove() {
        List<String> list = new ArrayList(Arrays.asList("a", "b", "c", "d"));

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.equals("c")) {
                it.remove();
            }
        }

        Stream.of(list).forEach(System.out::println);

    }
}
