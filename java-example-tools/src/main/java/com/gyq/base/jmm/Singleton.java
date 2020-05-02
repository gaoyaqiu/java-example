package com.gyq.base.jmm;

/**
 * 单例模式——双重检验锁模式(建议在1.4以上版本使用，低版本jvm对于volatile关键字的实现会导致双重检查加锁失效).
 *
 * @auther gaoyaqiu
 */
public class Singleton {

    private Singleton() {
    }

    /**
     * 使用volatile关键字，保证了多线程下对该实例操作是共享的
     * 查看汇编指令：-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -Xcomp
     */
    private static volatile Singleton instance;

    private static Singleton getInstance() {
        // 减少锁带来的性能损耗，不用每次都通过加锁来判断对象是否为空
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
