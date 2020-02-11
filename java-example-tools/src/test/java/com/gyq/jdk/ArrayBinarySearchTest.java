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
public class ArrayBinarySearchTest {

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
        System.out.println("查找之前: " + JsonUtil.object2Json(array));

        Arrays.sort(array, Comparator.comparing(Foo::getNum));
        System.out.println("先排序: " + JsonUtil.object2Json(array));

        int index = Arrays.binarySearch(array, new Foo(5), Comparator.comparing(Foo::getNum));
        if (index < 0) {
            System.out.println("没有找到 5");
            return;
        }
        System.out.println("查找的结果为：" + JsonUtil.object2Json(array[index]));
    }

    @Data
    @AllArgsConstructor
    class Foo {
        private int num;
    }
}
