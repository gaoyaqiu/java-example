package com.gyq.base.io;

import java.io.*;

/**
 * PipedReader 与 PipedWriter 学习笔记.
 *
 * @author gaoyaqiu
 */
public class PipedReaderWriterDemo {

    public static void main(String[] args) throws Exception{
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader(out);

        Thread outThread = new Thread(() -> {
            try {
                out.write("你好， pipe!");
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread inThread = new Thread(() -> {
            int length;
            char[] data = new char[1024];
            try {
                while ((length = in.read(data)) != -1) {
                    System.out.println(data);
                }
                in.close();
            } catch (IOException e){
                e.printStackTrace();
            }

        });

        outThread.start();
        inThread.start();
    }
}
