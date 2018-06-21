package com.gyq.pattern.proxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Proxy;
import org.junit.Before;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author gaoyaqiu
 * @date 2018/6/21
 */
public class CglibProxyTest {

    @Before
    public void init(){
        // 设置cglib生成的代理类字节码目录
      //  System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/gaoyaqiu/Downloads/bak/test/");
    }

    @Test
    public void test() throws IOException {
        Agency agency = new Agency();
        Person person = (Person) agency.getInstance(new Person());

        System.out.println(person.getClass());
        person.findHourse();

        // 阻塞程序
        System.in.read();
    }
}
