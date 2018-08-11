package com.gyq.pattern.proxy.staticproxy;

import com.gyq.pattern.proxy.Person;

/**
 * 李四买房.
 *
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class LiSi implements Person {

    @Override
    public void findHourse() {
        System.out.println("我是土豪，这房不错，我要了！");
    }
}
