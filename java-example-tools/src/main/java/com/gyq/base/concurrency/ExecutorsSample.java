package com.gyq.base.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author qiu
 * @date 2020/5/5
 */
public class ExecutorsSample {

  public static void main(String[] args) {
    ScheduledExecutorService es = Executors.newScheduledThreadPool(1);

    //延迟三秒执行
    es.schedule(new Runnable() {
      @Override
      public void run() {
        System.out.println("我在跑......");
      }
    }, 3, TimeUnit.SECONDS);

    es.shutdown();

  }
}
