package com.gyq.pattern.proxy.customdynamicproxy;

import com.gyq.pattern.proxy.Person;
import com.gyq.pattern.proxy.staticproxy.LiSi;

/**
 * 手动实现动态代理（参考JDK动态代理）.
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class CustomDynamicMain {

    public static void main(String[] args) {
        Person person = (Person) MyProxy.newProxyInstance(new MyClassLoader(), new Class[]{Person.class}, new AgencyProxy(new LiSi()));
        person.findHourse();

        System.out.println(person.getClass());
    }
}
