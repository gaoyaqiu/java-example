package com.gyq.pattern.singleton;

/**
 * 单例模式——懒汉式(线程安全).
 *
 * @auther gaoyaqiu
 */
public class LazyInitializedThreadSafeSingleton {

    private LazyInitializedThreadSafeSingleton() {
    }

    private static LazyInitializedThreadSafeSingleton instance = null;

    /**
     * 加了synchronized来阻塞多线程并发请求，延长了程序的响应时间, 降低了程序的性能，造成资源浪费.
     *
     * @return
     */
    public static synchronized LazyInitializedThreadSafeSingleton getInstance() {
        if (null == instance) {
            instance = new LazyInitializedThreadSafeSingleton();
        }

        return instance;
    }
}
