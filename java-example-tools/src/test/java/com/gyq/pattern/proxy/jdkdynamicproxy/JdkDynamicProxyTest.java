package com.gyq.pattern.proxy.jdkdynamicproxy;

import com.gyq.pattern.proxy.Person;
import com.gyq.pattern.proxy.staticproxy.LiSi;
import org.junit.Before;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public class JdkDynamicProxyTest {

    @Before
    public void init(){
       // System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    }

    @Test
    public void test() throws IOException {
        Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, new Agency(new LiSi()));
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
