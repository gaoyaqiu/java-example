package com.gyq.pattern.singleton;

import java.lang.reflect.Constructor;

/**
 * 测试静态内部类单例模式.
 *
 * @author gaoyaqiu
 * @date 2019/2/24
 */
public class ReflectionSingletonTest {
    public static void main(String[] args) {
        LazyInitializedInnerClassSingleton instanceOne = LazyInitializedInnerClassSingleton.getInstance();
        LazyInitializedInnerClassSingleton instanceTwo = null;
        try {
            Constructor[] constructors = LazyInitializedInnerClassSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                // 设置访问权限
                constructor.setAccessible(true);
                instanceTwo = (LazyInitializedInnerClassSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
