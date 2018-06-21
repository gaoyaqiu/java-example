package com.gyq.pattern.proxy.staticproxy;

import com.gyq.pattern.proxy.Person;

/**
 * 中介负责帮李四找房.
 *
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class Agency implements Person {
    private Person person;

    public Agency(Person person) {
        this.person = person;
    }

    @Override
    public void findHourse() {
        // 中介开始搜寻房子
        befor();

        // 找到之后就通知张三
        person.findHourse();

        // 收取中介费
        after();
    }

    private void befor() {
        System.out.println("四处搜寻房子。。。");
        System.out.println("找到合适房源, 通知客户");
    }

    private void after() {
        System.out.println("付中介费");
    }

}
