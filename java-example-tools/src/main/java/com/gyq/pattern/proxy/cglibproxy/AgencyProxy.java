package com.gyq.pattern.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author gaoyaqiu
 * @date 2018/6/21
 */
public class AgencyProxy implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象.
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        befor();
        proxy.invokeSuper(obj, args);
        after();
        return null;
    }


    private void befor() {
        System.out.println("我是cglib动态代理");
        System.out.println("我在XXX需要一套两室一厅新房，有现房就通知我");
        System.out.println("中介四处搜寻房子，已找到合适房源, 通知客户。。。");
    }

    private void after() {
        System.out.println("付中介费，合作愉快");
    }
}
