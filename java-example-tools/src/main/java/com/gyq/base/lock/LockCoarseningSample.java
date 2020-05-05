package com.gyq.base.lock;

/**
 * 锁粗化
 *
 * @author qiu
 */
public class LockCoarseningSample {

  StringBuffer sb = new StringBuffer();

  public void test() {
    // 因append方法加了锁，锁的是this当前这个实例对象，按照正常的思维逻辑，调用了三次append，相当于每一步都需要
    // 都有synchronized同步块，但是JVM会对加锁的机制做一个优化(锁的粗化-把加锁粒度放大了，加一个全局的锁)，本来每一段都需要加锁，只需要加一次即可
    //synchronized () {
    sb.append("1");
    sb.append("2");
    sb.append("3");
    // }
  }

  public static void main(String[] args) {
    LockCoarseningSample lockCoarseningSample = new LockCoarseningSample();
    lockCoarseningSample.test();
  }
}
