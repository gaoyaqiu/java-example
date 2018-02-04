package com.gyq.pattern.singleton;

/**
 * 单例模式——懒汉式.
 *
 * @auther gaoyaqiu
 */
public class LazySingleton {

    // 不允许外部实例化
    private LazySingleton() {
    }

    private static LazySingleton instance = null;

    /**
     * 注意: 当有多个线程同时执行时，可能会存在多个实例(非线程安全).
     *
     * @return
     */
    public static LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }

        return instance;
    }
}
