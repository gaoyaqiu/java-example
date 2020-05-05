package com.gyq.base.sample;

/**
 * 对象逃逸分析测试
 *
 * @author qiu
 */
public class StackAllocTest {

  /**
   * 进行两种测试
   * 关闭逃逸分析，同时调大堆空间，避免堆内GC的发生，如果有GC信息将会被打印出来
   * VM运行参数：-Xmx4G -Xms4G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
   *
   * 开启逃逸分析
   * VM运行参数：-Xmx4G -Xms4G -XX:+DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
   *
   * 执行main方法后
   * jps 查看进程
   * jmap -histo 进程ID
   */
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      // 关闭逃逸分析，Student实例有 50W 个，开启之后少于实例50W
      alloc();
    }
    long end = System.currentTimeMillis();
    //查看执行时间
    System.out.println("cost-time " + (end - start) + " ms");
    try {
      Thread.sleep(30000);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
  }

  private static Student alloc() {
    // Jit对编译时会对代码进行 逃逸分析
    // 并不是所有对象存放在堆区，有的一部分存在线程栈空间
    Student student = new Student();
    return student;
  }

  static class Student {

    private String name;
    private int age;
  }
}