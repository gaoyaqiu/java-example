package com.gyq.pattern.proxy.staticproxy;

import com.gyq.pattern.proxy.Person;

/**
 * 中介负责帮李四找房.
 *
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class AgencyProxy implements Person {
    private Person person;

    public AgencyProxy(Person person) {
        this.person = person;
    }

    @Override
    public void findHourse() {
        // 李四想买房
        befor();

        // 中介开始搜寻房子,找到之后就通知李四
        person.findHourse();

        // 收取中介费
        after();
    }

    private void befor() {
        System.out.println("我在XXX需要一套两室一厅新房，有现房就通知我");
        System.out.println("中介四处搜寻房子，已找到合适房源, 通知客户。。。");
    }

    private void after() {
        System.out.println("付中介费，合作愉快");
    }

}
