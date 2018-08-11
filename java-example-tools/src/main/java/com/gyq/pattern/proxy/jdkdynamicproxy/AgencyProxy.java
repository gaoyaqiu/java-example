package com.gyq.pattern.proxy.jdkdynamicproxy;

import com.gyq.pattern.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 中介负责帮李四找房.
 *
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class AgencyProxy implements InvocationHandler {

    /**
     * 被代理类
     */
    private Person person;

    public AgencyProxy(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        befor();

        method.invoke(person, args);

        after();

        return null;
    }


    private void befor() {
        System.out.println("我是JDK动态代理");
        System.out.println("我在XXX需要一套两室一厅新房，有现房就通知我");
        System.out.println("中介四处搜寻房子，已找到合适房源, 通知客户。。。");
    }

    private void after() {
        System.out.println("付中介费，合作愉快");
    }
}
