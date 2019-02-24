package com.gyq.learning.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gaoyaqiu
 * @date 2019/2/20
 */
public class ClassCaseDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add("A");

        List<Object> list2 = list;

        List<String> list3 = Collections.emptyList();
    }

    private static void exchange(List a, List b){
    }
}
