package com.gyq.base.concurrency;

import java.util.concurrent.Semaphore;

/**
 * @author qiu
 */
public class SemaphoreSample {

  public static void main(String[] args) {
    // 同一时间只能处理2个线程
    Semaphore semaphore = new Semaphore(2);
    for (int i = 0; i < 5; i++) {
      new Thread(new Task(semaphore, "zhangsan+" + i)).start();
    }
  }

  static class Task extends Thread {

    Semaphore semaphore;

    public Task(Semaphore semaphore, String tname) {
      this.semaphore = semaphore;
      this.setName(tname);
    }

    @Override
    public void run() {
      try {
        semaphore.acquire();
        System.out.println(
            Thread.currentThread().getName() + ":aquire() at time:" + System.currentTimeMillis());

        Thread.sleep(3000);

        semaphore.release();
       // System.out.println(Thread.currentThread().getName() + ":aquire() at time:" + System.currentTimeMillis());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
