package com.gyq.pattern.singleton;

/**
 * 单例模式——懒汉式(线程安全).
 *
 * @auther gaoyaqiu
 */
public class LazySingleton3 {

    private LazySingleton3() {
    }

    /**
     * 当LazySingleton3还没有被初始化时，因InnerClass加了static，所以也不会被加载，不会提前分配空间，
     * 当getInstance方法被调用之前InnerClass才会被加载，有效避免线程安全问题
     */
    private static class InnerClass {
        private static final LazySingleton3 INSTANCE = new LazySingleton3();
    }

    public static LazySingleton3 getInstance() {
        return InnerClass.INSTANCE;
    }
}
