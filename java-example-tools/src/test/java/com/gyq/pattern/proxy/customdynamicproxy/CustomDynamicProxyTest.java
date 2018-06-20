package com.gyq.pattern.proxy.customdynamicproxy;

import com.gyq.pattern.proxy.Person;
import com.gyq.pattern.proxy.staticproxy.LiSi;
import org.junit.Test;

import java.io.IOException;


/**
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class CustomDynamicProxyTest {

    @Test
    public void test() throws IOException {
        Person person = (Person) MyProxy.newProxyInstance(new MyClassLoader(), new Class[]{Person.class}, new MeiPo(new LiSi()));
        person.findLove();

        System.out.println(person.getClass());
    }
}
