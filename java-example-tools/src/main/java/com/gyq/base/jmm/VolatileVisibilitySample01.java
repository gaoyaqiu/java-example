package com.gyq.base.jmm;

/**
 * initFlag 更新并不会刷新回主存
 *
 * @author qiu
 */
public class VolatileVisibilitySample01 {
    private boolean initFlag = false;

    public void refresh(){
        // 当 initFlag 没有被 volatile 修饰(只是普通写操作，并不是 volatile 写)
        // 当值改动时，并不会立即刷回主内存，其它CPU也无法感知它的变化
        this.initFlag = true;
        String threadName = Thread.currentThread().getName();
        System.out.println("线程：" + threadName + ":修改共享变量 initFlag");
    }


    public void load(){
        String threadName = Thread.currentThread().getName();
        // 当这个线程感知到 initFlag 变量被修改为 true 之后就跳出循环
        while (!initFlag) {

        }
        System.out.println("当前线程：" + threadName + "嗅探到initFlag的状态改变");
    }

    public static void main(String[] args) {
        VolatileVisibilitySample01 sample = new VolatileVisibilitySample01();
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
