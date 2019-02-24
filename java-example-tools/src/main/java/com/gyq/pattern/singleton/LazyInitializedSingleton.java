package com.gyq.pattern.singleton;

/**
 * 单例模式——懒汉式(非线程安全).
 *
 * @auther gaoyaqiu
 */
public class LazyInitializedSingleton {

    /**
     * 不允许实例化
     */
    private LazyInitializedSingleton() {
    }

    private static LazyInitializedSingleton instance = null;

    /**
     * 当有多个线程同时执行时，会存在多个实例的情况.
     *
     * @return
     */
    public static LazyInitializedSingleton getInstance() {
        if (null == instance) {
            instance = new LazyInitializedSingleton();
        }

        return instance;
    }
}
