package com.gyq.pattern.proxy.staticproxy;

import org.junit.Test;

/**
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public final class StaticProxyTest {

    @Test
    public void test() {
        new Agency(new LiSi()).findHourse();
    }
}
