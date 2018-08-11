package com.gyq.pattern.proxy.cglibproxy;

import java.io.IOException;

/**
 * Cglib动态代理
 * <p>
 * 特点: 需要引入cglib的jar包，通过实现MethodInterceptor接口来实现动态代理
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class CglibMain {

    public static void main(String[] args) throws IOException {
        AgencyProxy agency = new AgencyProxy();
        Person person = (Person) agency.getInstance(new Person());

        System.out.println(person.getClass());
        person.findHourse();

        // 阻塞程序
//        System.in.read();
    }
}
