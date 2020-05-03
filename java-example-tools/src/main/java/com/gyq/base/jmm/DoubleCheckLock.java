package com.gyq.base.jmm;

/**
 * volatile 禁止指令重排序的例子
 *
 * 以下代码是一个经典的单例双重检测代码，当 instance 没有被 volatile 修饰时，在多线程环境下就能出现线程安全问题，原因在于某一个线程执行到第一次检测，读取到
 * instance 不为null时，instance的引用对象可能没有完成初始化。
 * 因为 instance = new DoubleCheckLock() 可以分为以下 三步 完成（伪代码）
 * memory = allocate(); // 1. 分配对象内存空间
 * instance(memory); // 2. 初始化对象
 * instance = memory; // 3. 设置instance指向刚分配的内存地址，此时 instance != null
 * 由于步骤1和步骤2之间可能会重排序，如下：
 * memory = allocate(); // 1. 分配对象内存空间
 * instance = memory; // 3. 设置instance指向刚分配的内存地址，此时 instance != null，`但是对象还没有初始化完成`
 * instance(memory); // 2. 初始化对象
 * 由于步骤2和3不存在数据依赖关系，而且无论重排前还是重排后，程序的执行结果在单线程中并没有改变，
 * 因此这种重排优化是允许的。但是指令重排只会保证串行语义的执行一致性（单线程），
 * 并不会关心多线程间的语义一致性，所以当一条线程访问 instance != null 时，
 * 由于 instance实例未必已初始化，也就造成了线程安全问题，那么该如何解决呢，
 * 可以使用 volatile 禁止 instance变量被处理器执行指令重排优化即可。
 *
 * @auther gaoyaqiu
 */
public class DoubleCheckLock {

    private DoubleCheckLock() {
    }

    /**
     * 禁止指令重排优化
     *
     * 查看汇编指令：-XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -Xcomp
     */
    private static volatile DoubleCheckLock instance;

    private static DoubleCheckLock getInstance() {
        // 第一次检测
        if (null == instance) {
            // 同步
            synchronized (DoubleCheckLock.class) {
                if (null == instance) {
                    // 多线程环境下可能会出问题的地方
                    instance = new DoubleCheckLock();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckLock.getInstance();
    }
}
