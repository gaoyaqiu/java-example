package com.gyq.base.jmm;

/**
 * 加上 syncharonized 同步块，就有可能产生竞争和阻塞，当出现上下文切换时，会重新从主存获取 initFlag 最新值
 * 解释：
 * 寄存器会将工作内存中的信息保存到任务的状态段中，当切换回来时，会在读回到CPU缓存中，
 * 就会有可能触发去主存中重新读取 initFlag值
 *
 * @author qiu
 */
public class VolatileVisibilitySample02 {
    private boolean initFlag = false;
    private Object object = new Object();

    public void refresh(){
        // 当 initFlag 没有被 volatile 修饰(只是普通写操作，并不是 volatile 写)
        // 当值改动时，并不会立即刷回主内存，其它CPU也无法感知它的变化
        this.initFlag = true;
        String threadName = Thread.currentThread().getName();
        System.out.println("线程：" + threadName + ":修改共享变量 initFlag");
    }


    public void load(){
        String threadName = Thread.currentThread().getName();
        int i = 0;
        // 当这个线程感知到 initFlag 变量被修改为 true 之后就跳出循环
        while (!initFlag) {
            synchronized (object) {
                i++;
            }
        }
        System.out.println("当前线程：" + threadName + "嗅探到initFlag的状态改变");
    }

    public static void main(String[] args) {
        VolatileVisibilitySample02 sample = new VolatileVisibilitySample02();
        Thread thread1 = new Thread(()->{
            sample.refresh();
        }, "thread1");

        Thread thread2 = new Thread(()->{
            sample.load();
        }, "thread2");

        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
    }

}
