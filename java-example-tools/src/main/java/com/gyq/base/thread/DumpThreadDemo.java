package com.gyq.base.thread;

/**
 * @author gaoyaqiu
 */
public class DumpThreadDemo {

    public static void main(String[] args) {
        // Thread API，底层是打印到错误输出流
        Thread.dumpStack();

        // 打印到标准的输出流中
        new Throwable("Stack trace").printStackTrace(System.out);
    }
}
