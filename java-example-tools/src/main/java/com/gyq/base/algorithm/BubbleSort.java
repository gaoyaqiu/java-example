package com.gyq.base.algorithm;

import java.util.stream.Stream;

/**
 * @author gaoyaqiu
 * @date 2019/3/10
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {

        int size = values.length;

        for (int i = 0; i < size; i++) {
            // 第 i 号元素
            T t = values[i]; // 产生临时变量
            for (int j = i + 1; j < size; j++) {
                // 第 i 号元素与 i + 1 对比
                if (t.compareTo(values[j]) == 1) { // 低位 > 高位
                    // 交换元素 [i + 1] = [i]
                    values[i] = values[j];
                    values[j] = t;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 1, 2, 5, 4);

        int size = values.length;

        for (int i = 0; i < size; i++) {
            // 第 i 号元素
            int t = values[i];
            for (int j = i + 1; j < size; j++) {
                if (values[i] > values[j]) {
                    // 交换元素 [i + 1] = [i]
                    values[i] = values[j];
                    values[j] = t;
                    break;
                }
            }
        }


//        Sort<Integer> sort = new BubbleSort<>();
//        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }
}
