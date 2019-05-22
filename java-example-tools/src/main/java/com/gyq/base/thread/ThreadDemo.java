package com.gyq.base.thread;

/**
 * @author gaoyaqiu
 */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        // Thread 实现 Runnable，如果没有传递 Runnable 对象实现， 则会空执行一次
        Thread thread = new Thread(ThreadDemo::sayHelloWorld);

        // 启动线程
        thread.start();

        // 等待线程结束(可以让线程变成同步)
        thread.join();

        System.out.println("Hello Next...");
        System.out.println(thread.getState());
    }

    public static void sayHelloWorld() {
        System.out.printf("线程 [Id : %s] : Hello,World!\n", Thread.currentThread().getId());
    }
}
