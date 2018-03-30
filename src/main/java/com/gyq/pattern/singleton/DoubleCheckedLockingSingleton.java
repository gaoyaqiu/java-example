package com.gyq.pattern.singleton;

/**
 * 单例模式——双重检验锁模式(建议在1.4以上版本使用，低版本jvm对于volatile关键字的实现会导致双重检查加锁失效).
 *
 * @auther gaoyaqiu
 */
public class DoubleCheckedLockingSingleton {

    private DoubleCheckedLockingSingleton() {
    }

    // 使用volatile关键字，保证了多线程下对该实例操作的可见性
    private static volatile DoubleCheckedLockingSingleton instance;

    private static DoubleCheckedLockingSingleton getInstance() {
        if (null == instance) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }

        return instance;
    }
}