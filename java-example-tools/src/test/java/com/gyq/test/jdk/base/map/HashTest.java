package com.gyq.test.jdk.base.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaoyaqiu
 * @date 2019/3/9
 */
public class HashTest {


    @Test
    public void testHashMap() {
        System.out.println("==========================");
        Map<String, String> m = new HashMap();
//        for (int i = 0; i < 18; i++) {
//            m.put((char) (i + 65) + (char) (i + 66) + (char) (i + 67) + "", i + ">>>https://www.gaoyaqiu.com/");
//        }
        System.out.println("==========================");

        String str = m.put("aaasdfs", "666");

        System.out.println(str);
    }
}
