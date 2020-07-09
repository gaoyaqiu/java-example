package com.gyq.base.array;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gaoyaqiu
 */
@Data
@AllArgsConstructor
public class ArrayDemo {

    private Integer s;

    public static void main(String[] args) {


//         String[] str = {["v2.11.0","v2.2.0","v.2.2","v2.1.234","V1.2.3","V1","V3.2"]}
//        System.out.println(str);
//
//        List<ArrayDemo> list = ImmutableList.of(
//                new ArrayDemo(300),
//                new ArrayDemo(400),
//                new ArrayDemo(100),
//                new ArrayDemo(50),
//                new ArrayDemo(150));
//
//
//        // 排序
//        ArrayDemo[] array = new ArrayDemo[list.size()];
//        list.toArray(array);
//
//        System.out.println("排序之前：" + JsonUtil.object2Json(array));
//        Arrays.sort(array, Comparator.comparing(ArrayDemo::getS));
//        System.out.println("排序之后：" + JsonUtil.object2Json(array));
//
//        // 二分查找
//        System.out.println();
//        System.out.println("查找之前" + array);
//        int i = Arrays.binarySearch(array, new ArrayDemo(150), Comparator.comparing(ArrayDemo::getS));
//        if (i < 0) {
//            throw new RuntimeException("没有找到");
//        }
//        System.out.println("查找结果：" + array[i]);
    }
}
