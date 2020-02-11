package com.gyq.jdk;

import com.google.common.collect.ImmutableList;
import com.gyq.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author gaoyaqiu
 */
public class ArraySortTest {

    @Test
    public void testSort() {
        List<Foo> list = ImmutableList.of(
                new Foo(100),
                new Foo(400),
                new Foo(5),
                new Foo(666),
                new Foo(345)
        );

        Foo[] array = new Foo[list.size()];
        list.toArray(array);
        System.out.println("排序之前: " + JsonUtil.object2Json(array));

        Arrays.sort(array, Comparator.comparing(Foo::getNum));
        System.out.println("排序之后(升序): " + JsonUtil.object2Json(array));

        Arrays.sort(array, Comparator.comparing(Foo::getNum).reversed());
        System.out.println("排序之后(降序): " + JsonUtil.object2Json(array));
    }

    @Data
    @AllArgsConstructor
    class Foo {
        private int num;
    }
}


