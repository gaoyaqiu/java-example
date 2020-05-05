package com.gyq.base.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 模拟陪媳妇去看病场景
 *
 * 医院里边排队的人很多，如果一个人的话，要先看大夫，看完大夫再去排队交钱取药。 现在我们是双核，
 * 可以同时做这两个事(多线程)。 假设看大夫花3秒钟，排队交费取药花5秒钟。我们同时搞的话，5秒钟我们就能完成，
 * 然后 一起回家(回到主线程)
 *
 * @author qiu
 * @date 2020/5/5
 */
public class CountDownLaunchSample {

  public static void main(String[] args) throws InterruptedException {
    long now = System.currentTimeMillis();
    CountDownLatch countDownLatch = new CountDownLatch(2);
    new Thread(new SeeDoctorTask(countDownLatch)).start();
    new Thread(new QueueTask(countDownLatch)).start();
    //等待线程池中的2个任务执行完毕，否则一直
    countDownLatch.await();
    System.out.println("over，回家 cost:" + (System.currentTimeMillis() - now));
  }
}
