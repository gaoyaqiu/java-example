package com.gyq.pattern.singleton;

/**
 * 单例模式——懒汉式(线程安全).
 *
 * @auther gaoyaqiu
 */
public class LazyInitializedInnerClassSingleton {

    private LazyInitializedInnerClassSingleton() {
    }

    private static class InnerClass {
        private static final LazyInitializedInnerClassSingleton INSTANCE = new LazyInitializedInnerClassSingleton();
    }

    public static LazyInitializedInnerClassSingleton getInstance() {
        return InnerClass.INSTANCE;
    }
}
