package com.gyq.base.concurrency;

import com.gyq.utils.UnsafeInstance;

/**
 * Synchronized 跨方法加解锁的另一种方式
 *
 * @author qiu
 */
public class SynchronizedSample {

  private static Object object = new Object();

  public static void test1() {
    UnsafeInstance.reflectGetUnsafe().monitorEnter(object);
    System.out.println("do something...");
  }

  public static void test2() {
    UnsafeInstance.reflectGetUnsafe().monitorExit(object);
    System.out.println("test2....");
  }

  public static void main(String[] args) {
    test1();
    test2();
  }

}
