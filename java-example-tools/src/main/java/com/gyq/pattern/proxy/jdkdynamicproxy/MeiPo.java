package com.gyq.pattern.proxy.jdkdynamicproxy;

import com.gyq.pattern.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 媒婆负责帮别人找对象.
 *
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class MeiPo implements InvocationHandler {

    private Person person;

    public MeiPo(Person person){
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
        System.out.println("四处搜寻妹子。。。");
        System.out.println("找到妹子一枚, 通知客户");
    }

    private void after() {
        System.out.println("付介绍费");
    }
}
