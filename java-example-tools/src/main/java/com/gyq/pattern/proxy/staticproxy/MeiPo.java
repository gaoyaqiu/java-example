package com.gyq.pattern.proxy.staticproxy;

import com.gyq.pattern.proxy.Person;

/**
 * 媒婆负责帮别人找对象.
 *
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class MeiPo implements Person {
    private Person person;

    public MeiPo(Person person) {
        this.person = person;
    }

    @Override
    public void findLove() {
        // 在你确认之前进行海选，确认是不是符合要求的对象
        befor();

        // 找到之后就通知张三
        person.findLove();

        // 收取中介费
        after();
    }

    private void befor() {
        System.out.println("四处搜寻妹子。。。");
        System.out.println("找到妹子一枚, 通知客户");
    }

    private void after() {
        System.out.println("付介绍费");
    }

}
