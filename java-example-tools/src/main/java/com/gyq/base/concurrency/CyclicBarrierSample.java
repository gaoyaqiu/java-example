package com.gyq.base.concurrency;

import java.util.concurrent.CyclicBarrier;

/**
 * @author qiu
 * @date 2020/5/5
 */
public class CyclicBarrierSample implements Runnable {

  private CyclicBarrier cyclicBarrier;
  private int index;

  public CyclicBarrierSample(CyclicBarrier cyclicBarrier, int index) {
    this.cyclicBarrier = cyclicBarrier;
    this.index = index;
  }

  @Override
  public void run() {
    try {
      System.out.println("index: " + index);
      index--;
      cyclicBarrier.await();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws Exception {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(11, new Runnable() {
      @Override
      public void run() {
        System.out.println("所有特工到达屏障，准备开始执行秘密任务");
      }
    });

    for (int i = 0; i < 10; i++) {
      new Thread(new CyclicBarrierSample(cyclicBarrier, i)).start();
    }
    cyclicBarrier.await();
    System.out.println("全部到达屏障....");
  }
}
