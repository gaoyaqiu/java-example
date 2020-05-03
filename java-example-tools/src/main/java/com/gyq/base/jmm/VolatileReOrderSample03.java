package com.gyq.base.jmm;

import com.gyq.utils.UnsafeInstance;

/**
 * 并发场景下存在指令重排（通过Unsafe手动加内存屏障 ）
 *
 * @author qiu
 * @date 2020/5/3
 */
public class VolatileReOrderSample03 {

  private static int x = 0, y = 0;
  private static int a = 0, b = 0;

  public static void main(String[] args) throws InterruptedException {
    int i = 0;

    for (; ; ) {
      i++;
      x = 0;
      y = 0;
      a = 0;
      b = 0;
      Thread t1 = new Thread(() -> {
        // 由于线程1先启动，下面这句让它等一等线程2
        shortWait(100000);
        a = 1; // 读还是写？store 写，volatile 写
        // sotreload ，读写屏障，不允许volatile写与第二步volatile读发生重排
        // 手动加内存屏障
        UnsafeInstance.reflectGetUnsafe().storeFence();
        x = b; // 读还是写？这里读写都有，先读volatile，然后再写普通变量
        // 分两步，先volatile读，将b读取到工作内存，再去普通写
      });

      Thread t2 = new Thread(() -> {
        b = 1;
        // 手动加内存屏障
        UnsafeInstance.reflectGetUnsafe().storeFence();
        y = a;
      });
      t1.start();
      t2.start();
      // 让两个线程同时加入到主线程中，主线程等待两个线程执行完毕之后，输出结果
      t1.join();
      t2.join();
      /**
       * x/y 会打印出哪些可能的结果
       * 1. 线程1运行到a=1，线程2运行到b=1，结果：1,1
       * 2. 线程1先执行完，线程2才执行，结果为：0,1
       * 3. 线程2先执行完，线程1才执行，结果为：1,0
       * 4. 0,0(当出现这种情况时，CPU或JIT对我们代码进行了指令重排，将 x = b; 和 y = a; 放在了前一个指令之前先执行)
       * 说明此程序并没有遵循happens-before原则，因为数据之间没有任何的依赖关系，处理器感知不到指令重排会对程序的执行结果造成影响.
       *
       */
      String result = String.format("第%d次 (%d,%d)", i, x, y);
      if (x == 0 && y == 0) {
        System.err.println(result);
        break;
      } else {
        System.out.println(result);
      }
    }
  }

  private static void shortWait(int interval) {
    long start = System.nanoTime();
    long end;
    do {
      end = System.nanoTime();
    } while (start + interval >= end);
  }
}
