package com.gyq.pattern.singleton;

/**
 * 单例模式——懒汉式(线程安全).
 *
 * @auther gaoyaqiu
 */
public class LazySingleton2 {

    private LazySingleton2() {
    }

    private static LazySingleton2 instance = null;

    /**
     * 加了synchronized来阻塞多线程并发请求，延长了程序的响应时间, 降低了程序的性能，造成资源浪费.
     *
     * @return
     */
    public static synchronized LazySingleton2 getInstance() {
        if (null == instance) {
            instance = new LazySingleton2();
        }

        return instance;
    }
}
