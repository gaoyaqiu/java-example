package com.gyq.jdk;

import com.gyq.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author gaoyaqiu
 */
public class CollectionTest {

    @Test
    public void testSort() {
        List<Foo> list = Arrays.asList(
                new Foo(100),
                new Foo(400),
                new Foo(5),
                new Foo(666),
                new Foo(345)
        );
        System.out.println("排序之前: " + JsonUtil.object2Json(list));

        Collections.sort(list, Comparator.comparing(Foo::getNum));

        System.out.println("排序之后（升序）: " + JsonUtil.object2Json(list));

        Collections.sort(list, Comparator.comparing(Foo::getNum).reversed());

        System.out.println("排序之后（降序）: " + JsonUtil.object2Json(list));
    }

    @Test
    public void testBinarySearch(){
        List<Foo> list = Arrays.asList(
                new Foo(100),
                new Foo(400),
                new Foo(5),
                new Foo(666),
                new Foo(345)
        );
        Collections.sort(list, Comparator.comparing(Foo::getNum));
        System.out.println("先排序: " + JsonUtil.object2Json(list));

        int index = Collections.binarySearch(list, new Foo(400), Comparator.comparing(Foo::getNum));
        if (index < 0) {
            System.out.println("没有找到 400");
            return;
        }
        System.out.println("查找的结果为：" + JsonUtil.object2Json(list.get(index)));
    }

    @Data
    @AllArgsConstructor
    class Foo {
        private int num;
    }
}
