package com.gyq.pattern.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import static org.hamcrest.core.Is.is;

/**
 * 单例测试.
 *
 * @auther gaoyaqiu
 */
public final class SingletonTest {

    /**
     * 需要多测试几次，或者增加线程数，就能测出多实例的情况
     */
    @Test
    public void lazySingleton1Test() {
        int thread = 100;
        CountDownLatch latch = new CountDownLatch(thread);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < thread; i++) {
            new Thread(() -> {
                latch.countDown();
                LazySingleton1 obj = LazySingleton1.getInstance();
                set.add(obj.hashCode());
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertThat(set.size(), is(1));
    }


    @Test
    public void lazySingleton2Test() {
        int thread = 100;
        CountDownLatch latch = new CountDownLatch(thread);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < thread; i++) {
            new Thread(() -> {
                latch.countDown();
                LazySingleton2 obj = LazySingleton2.getInstance();
                set.add(obj.hashCode());
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertThat(set.size(), is(1));
    }

    @Test
    public void lazySingleton3Test() {
        int threadNumber = 100;
        CountDownLatch latch = new CountDownLatch(threadNumber);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < threadNumber; i++) {
            new Thread(() -> {
                latch.countDown();
                LazySingleton3 obj = LazySingleton3.getInstance();
                set.add(obj.hashCode());
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertThat(set.size(), is(1));
    }

    @Test
    public void regSingletonTest() {
        int threadNumber = 100;
        CountDownLatch latch = new CountDownLatch(threadNumber);

        Set<String> set = new HashSet<>();
        for (int i = 0; i < threadNumber; i++) {
            new Thread(() -> {
                latch.countDown();
                RegSingleton obj = RegSingleton.getInstance(RegSingleton.class.getName());
                set.add(Integer.toHexString(obj.hashCode()));
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertThat(set.size(), is(1));
    }
}
