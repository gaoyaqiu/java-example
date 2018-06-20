package com.gyq.pattern.proxy.customdynamicproxy;

import java.lang.reflect.Method;

/**
 * @author gaoyaqiu
 * @date 2018/6/20
 */
public interface MyInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
