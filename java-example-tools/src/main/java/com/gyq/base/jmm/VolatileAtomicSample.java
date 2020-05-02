package com.gyq.base.jmm;

/**
 * volatile 无法保证原子性
 *
 * @author qiu
 */
public class VolatileAtomicSample {

  private static volatile int counter = 0;

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(() -> {
        for (int j = 0; j < 10000; j++) {
          // 不是原子操作，当counter值被修改，刷回主存之后，其它CPU计算就会无效，就出现少计算的情况，最终值会小于 10000
          counter++;
        }
      });
      thread.start();
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(counter);
  }
}
