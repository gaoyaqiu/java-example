package com.gyq.pattern.proxy.jdkdynamicproxy;

import com.gyq.pattern.proxy.Person;
import com.gyq.pattern.proxy.staticproxy.LiSi;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * 动态代理(结构型设计模式).
 * <p>
 * 特点: 通过jdk InvocationHandler接口来实现动态代理
 * 缺点：被代理类一定要实现某个接口，比如LiSi实现了Person接口，如果我们的类原本是没有实现接口的，总不能为了用代理而特意去加一个接口吧，
 * 如果要解决该问题，可以使用cglib动态代理，它是基于类做的代理。最后代理类由于做了很多额外的操作，效率上可能有一定影响
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class JdkDynamicMain {

    public static void main(String[] args) throws IOException {
        Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, new AgencyProxy(new LiSi()));
        person.findHourse();

        // 查看代理之后的类名
        System.out.println(person.getClass());

        // 获取字节码
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy4", new Class[]{Person.class});

        // 输出到class文件
        FileOutputStream os = new FileOutputStream("/Users/gaoyaqiu/Downloads/bak/test/$Proxy4.class");
        os.write(data);
        os.close();

        // 用反编译软件查看class文件
    }
}
