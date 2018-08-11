package com.gyq.pattern.singleton;

/**
 * 单例模式——懒汉式(非线程安全).
 *
 * @auther gaoyaqiu
 */
public class LazySingleton1 {

    /**
     * 不允许实例化
     */
    private LazySingleton1() {
    }

    private static LazySingleton1 instance = null;

    /**
     * 当有多个线程同时执行时，可能会存在多个实例.
     *
     * @return
     */
    public static LazySingleton1 getInstance() {
        if (null == instance) {
            instance = new LazySingleton1();
        }

        return instance;
    }
}
