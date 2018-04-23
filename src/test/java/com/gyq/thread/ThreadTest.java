package com.gyq.thread;

import org.junit.Test;

/**
 * wait、notify方法学习.
 *
 * @author gaoyaqiu
 */
public class ThreadTest {

    @Test
    public void test() {
        ZhangSan zhangSan = new ZhangSan("张三");
        LiSi liSi = new LiSi("李四");

        // 张三先走
        new Thread(zhangSan).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 测试是否会影响到张三的线程，把张三线程给释放了, 结果并不会，因为wait、notify方法作用域只在当前的对象上
        liSi.release();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 释放张三线程
        zhangSan.release();
    }
}
