package com.gyq.jdk;

/**
 * @author gaoyaqiu
 */
public class LongTest {
    public static void main(String[] args) {
        Long cache[] = new Long[-(-128) + 127 + 1];
        for(int i = 0; i < cache.length; i++)
            cache[i] = new Long(i - 128);

        System.out.println(cache[132]);
    }

}
