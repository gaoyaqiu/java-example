package com.gyq.pattern.proxy.customdynamicproxy;

import com.gyq.pattern.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 中介负责帮李四找房.
 *
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class Agency implements MyInvocationHandler {

    private Person person;

    public Agency(Person person){
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
        System.out.println("我是自定义动态代理");
        System.out.println("四处搜寻房子。。。");
        System.out.println("找到合适房源, 通知客户");
    }

    private void after() {
        System.out.println("付中介费");
    }
}
