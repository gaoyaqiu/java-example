package com.gyq.pattern.singleton;

/**
 * 单例模式——饿汉式(线程安全).
 *
 * @auther gaoyaqiu
 */
public class EagerlySingleton {

    private EagerlySingleton() {
    }

    /**
     * 在类加载时就创建好了实例
     */
    private static EagerlySingleton instance = new EagerlySingleton();

    public static EagerlySingleton getInstance() {
        return instance;
    }
}
