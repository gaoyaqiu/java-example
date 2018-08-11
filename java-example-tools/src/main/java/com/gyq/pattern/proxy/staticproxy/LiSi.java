package com.gyq.pattern.proxy.staticproxy;

import com.gyq.pattern.proxy.Person;

/**
 * 张三买房.
 *
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class LiSi implements Person {

    @Override
    public void findHourse() {
        System.out.println("我在XXX需要一套两室一厅新房，有现房就通知我");
        System.out.println("这房不错，我要了！");
    }
}