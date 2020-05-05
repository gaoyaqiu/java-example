package com.gyq.base.lock;


/**
 * 锁的消除
 *
 * @author qiu
 */

public class LockEliminationSample {

  public void test2() {
    // JVM不会对同步块进行加锁
    synchronized (new Object()) {
      // do something...
      System.out.println("test2...");
      // JVM会进行逃逸分析，发现此处加锁并不会被其它线程所感知到，不可能会出现逃逸
    }
  }
}
