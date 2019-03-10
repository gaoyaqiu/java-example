package com.gyq.base.algorithm;

/**
 * 排序接口.
 *
 * @author gaoyaqiu
 * @date 2019/3/10
 */
public interface Sort<T extends Comparable<T>> {

    void sort(T[] values);


    static <T> T[] of(T... values) {
        return values;
    }
}
