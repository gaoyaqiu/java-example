package com.gyq.base.array;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * @author gaoyaqiu
 */
public class IteratorRemoveDemo {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 5, 5, 5, 4);

        Iterator it = list.iterator();
        while (it.hasNext()) {
            if ((int)it.next() == 5) {
                it.remove();
            }
            System.out.print(list + "\t");
            System.out.println();
        }
//        System.out.println(list);
    }
}
