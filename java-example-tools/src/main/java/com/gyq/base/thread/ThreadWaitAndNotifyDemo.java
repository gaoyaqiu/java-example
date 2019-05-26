package com.gyq.base.thread;

/**
 * @author gaoyaqiu
 */
public class ThreadWaitAndNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        // wait() 语义： 在同步（互斥）场景下

        // Lock 场景： T1、T2, 互斥访问资源 R
        // T1 获取 L(T1) -> T2 获取 L(T2)
        // T1.wait() T2.wait() 都要被阻塞（停顿）
        Thread t1 = new Thread(ThreadWaitAndNotifyDemo::sayHelloWorld);
        t1.setName("T1");
        // 启动线程
        t1.start();

        Thread t2 = new Thread(ThreadWaitAndNotifyDemo::sayHelloWorld);
        t2.setName("T2");
        // 启动线程
        t2.start();

        // 调用 wait() 方法的对象和调用 notify() 方法必须是同一对象，因此以下调用是错误的示范
        Object monitor = ThreadWaitAndNotifyDemo.class;
//        synchronized (monitor) {
//            t1.notify();
//            t2.notify();
//        }

        // 正确的写法
        synchronized (monitor) {
            monitor.notifyAll();
        }
    }

    public static void sayHelloWorld() {
        Thread currntThread = Thread.currentThread();

        Object monitor = ThreadWaitAndNotifyDemo.class;
        synchronized (monitor) {
            try {
                System.out.printf("线程[%s] 进入等待状态...\n", currntThread.getName());
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("线程[%s] 恢复执行...\n", currntThread.getName());
        }

    }
}
