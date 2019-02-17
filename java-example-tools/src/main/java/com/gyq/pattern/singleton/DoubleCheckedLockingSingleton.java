package com.gyq.pattern.singleton;

/**
 * 单例模式——双重检验锁模式(建议在1.4以上版本使用，低版本jvm对于volatile关键字的实现会导致双重检查加锁失效).
 *
 * @auther gaoyaqiu
 */
public class DoubleCheckedLockingSingleton {

    private DoubleCheckedLockingSingleton() {
    }

    /**
     * 使用volatile关键字，保证了多线程下对该实例操作是共享的
     */
    private static volatile DoubleCheckedLockingSingleton instance;

    private static DoubleCheckedLockingSingleton getInstance() {
        // 减少锁带来的性能损耗，不用每次都通过加锁来判断对象是否为空
        if (null == instance) {
            // 防止多个线程同时执行到这块代码，所以需要加锁
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }

        return instance;
    }
}
