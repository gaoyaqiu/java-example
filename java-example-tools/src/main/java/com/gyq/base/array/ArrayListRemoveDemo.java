package com.gyq.base.array;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author gaoyaqiu
 */
public class ArrayListRemoveDemo {

    /**
     * 演示想从arraylist中删除数字5时，其实并不能将3个5都删除，最终会有一个5删不掉，
     * 原因是： 每次删除一个元素之后，会将后面的元素往前移动，并将最后一个元素赋值为 null（为了gc），
     * 而此时 i 一直在增长，导致有一个 5 被遗漏
     * i = 0   1,5,5,5,4
     * i = 1   1,5,5,4,null (删掉第二个5)
     * i = 2   1,5,4,null,null (遗漏第二个5)
     * i = 3   1,5,4,null,null (循环结束，后面都是null)
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 5, 5, 5, 4);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 5) {
                list.remove(i);
            }
        }

        System.out.println(list);
    }
}
