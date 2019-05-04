package com.gyq.base.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * PipedInputStream 与 PipedOutStream 学习笔记.
 *
 * @author gaoyaqiu
 */
public class PipedInputOutputStreamDemo {

    public static void main(String[] args) throws Exception {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream in = new PipedInputStream(out);

        Thread outThread = new Thread(() -> {
            try {
                out.write("Hello World, pipe!".getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread inThread = new Thread(() -> {
            int length;
            byte[] data = new byte[1024];
            try {
                while ((length = in.read(data)) != -1) {
                    System.out.println(new String(data));
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
