package com.gyq.pattern.singleton;

/**
 * 单例模式——饿汉式.
 *
 * @auther gaoyaqiu
 */
public class EagerlySingleton {

    private EagerlySingleton() {
    }

    // 当jvm在加载这个类时，会立即创建该实例，保证了线程安全
    private static EagerlySingleton instance = new EagerlySingleton();

    public static EagerlySingleton getInstance() {
        return instance;
    }
}
