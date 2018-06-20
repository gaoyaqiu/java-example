package com.gyq.pattern.proxy.staticproxy;

import com.gyq.pattern.proxy.Person;

/**
 * 张三找对象.
 *
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class LiSi implements Person {

    private String sex = "男";

    @Override
    public void findLove() {
        System.out.println("我需要妹子，有合适人选就通知我");
    }
}
