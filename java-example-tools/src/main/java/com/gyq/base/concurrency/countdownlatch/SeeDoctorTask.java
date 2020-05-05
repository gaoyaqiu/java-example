package com.gyq.base.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 模拟看医生任务
 *
 * @author qiu
 * @date 2020/5/5
 */
public class SeeDoctorTask implements Runnable {

  private CountDownLatch countDownLatch;

  public SeeDoctorTask(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    try {
      System.out.println("开始看医生");
      Thread.sleep(2000);
      System.out.println("看医生结束，准备离开病房");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if (countDownLatch != null) {
        countDownLatch.countDown();
      }
    }
  }
}
