package com.gyq.base.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // 4 -> 3 -> 2 -> 1
        CountDownLatch latch = new CountDownLatch(4);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> {
                echoThread();
                latch.countDown(); // -1
            });
        }

        Thread.sleep(1000L);
        System.out.println("CountDownLatch 剩余数量：" + latch.getCount());
        // countDown <= i 否则会一直阻塞，等于0时才会释放
        latch.await();
        executorService.shutdown();
    }

    private static void echoThread() {
        System.out.printf("当前线程[%s]正在执行...\n", Thread.currentThread().getName());
    }
}
