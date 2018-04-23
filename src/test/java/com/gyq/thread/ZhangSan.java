package com.gyq.thread;

import lombok.AllArgsConstructor;

/**
 * @author gaoyaqiu
 */
@AllArgsConstructor
public class ZhangSan implements Runnable {

    private String name;

    @Override
    public synchronized void run() {
        try {
            System.out.println(name + "---来了,开始等待");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + "---被唤醒, 开始工作");

    }

    /**
     * 释放在等待的线程
     */
    public synchronized void release() {
        System.out.println("通知[" + name + "]准备工作");
        notify();
    }
}
