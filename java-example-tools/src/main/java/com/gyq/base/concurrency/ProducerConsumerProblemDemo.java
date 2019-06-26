package com.gyq.base.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 生产者、消费者示例.
 *
 * @author gaoyaqiu
 * @date 2019/6/26
 */
public class ProducerConsumerProblemDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Container container = new Container();
        Future producerFuture = executorService.submit(() -> {
            container.produce();
        });

        Future consumerFuture = executorService.submit(() -> {
            container.consumer();
        });

        Thread.sleep(1000);
        executorService.shutdown();
    }

    public static class Container {

        private List<Integer> data = new LinkedList<>();
        private Random random = new Random();

        private static final int MAX_SIZE = 5;

        public void produce() {
            while (true) {
                try {
                    synchronized (this) {
                        while (data.size() >= MAX_SIZE) {
                            wait();
                        }

                        int value = random.nextInt(10);
                        System.out.printf("线程[%s] 正在生产数据：%d\n", Thread.currentThread().getName(), value);
                        data.add(value);

                        notify();
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }

        public void consumer() {
            while (true) {
                try {
                    synchronized (this) {
                        if (data.isEmpty()) {
                            wait();
                        }

                        int value = data.remove(0);
                        System.out.printf("线程[%s] 正在消费数据： %d\n", Thread.currentThread().getName(), value);

                        notify();
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
