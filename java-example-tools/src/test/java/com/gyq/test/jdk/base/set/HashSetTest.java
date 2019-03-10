package com.gyq.test.jdk.base.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gaoyaqiu
 * @date 2019/3/10
 */
public class HashSetTest {

    @Test
    public void hashSetTest() {
        Set<String> set = new HashSet<>();

        System.out.println(set.add("a"));
        System.out.println(set.add("a"));

        System.out.println(set.size());
    }
}
