package com.gyq.base.concurrency;

/**
 * 线程死锁案例(互相持有对象资源).
 *
 * @author gaoyaqiu
 * @date 2019/6/26
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        new Thread(() -> {
            synchronized (o1){

                System.out.printf("Thread[ ID: %d] holds o1\n", Thread.currentThread().getId());
                synchronized (o2){
                    System.out.printf("Thread[ ID: %d] holds o2\n", Thread.currentThread().getId());
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (o2){
                System.out.printf("Thread[ ID: %d] holds o2\n", Thread.currentThread().getId());
                synchronized (o1){
                    System.out.printf("Thread[ ID: %d] holds o1\n", Thread.currentThread().getId());
                }
            }
        }).start();
    }
}
