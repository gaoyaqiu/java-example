package com.gyq.base.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile 学习笔记.
 *
 * @author gaoyaqiu
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/gaoyaqiu/Downloads/bak/io/data.txt");

        // 以读写方式打开文件，并写入数据
        readAndWrite(file);

        line();

        // 以只读方式打开文件，读取文件内容
        randomRead(file);

        line();

        // 修改最后一个数字
        updateData(file);
        randomRead(file);
    }

    public static void read(File file) throws IOException {
        // 以读写方式打开文件，并写入数据
        readAndWrite(file);

        line();

        // 以只读方式打开文件，读取文件内容
        randomRead(file);

        line();

        // 修改最后一个数字
        updateData(file);
        randomRead(file);
    }

    public static void readAndWrite(File file) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 5; i++) {
            raf.writeInt(i * 2);
        }
        raf.writeUTF("end");
        raf.close();
    }

    public static void randomRead(File file) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 5; i++) {
            System.out.println(raf.readInt());
        }
        System.out.println(raf.readUTF());
        raf.close();
    }

    public static void updateData(File file) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(4 * 4);
        raf.writeInt(66666);
        raf.close();
    }

    private static void line() {
        System.out.println();
    }

}
