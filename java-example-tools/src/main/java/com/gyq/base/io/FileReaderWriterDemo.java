package com.gyq.base.io;

import java.io.*;

/**
 * FileReader 与 FileWriter 学习笔记.
 *
 * @author gaoyaqiu
 */
public class FileReaderWriterDemo {
    public static void main(String[] args) throws IOException {
        // 1. 创建数据来源于目的地
        File src = new File("/Users/gaoyaqiu/Downloads/bak/io/src_char.txt");
        File dest = new File("/Users/gaoyaqiu/Downloads/bak/io/dest_char.txt");
        // 2. 自动关闭资源
        try (Reader in = new FileReader(src);
             Writer out = new FileWriter(dest)) {
            // 3. 每次从来源文件读取 1024 字符
            char[] data = new char[1024];
            int length;
            /***
             * int read():每次读取一个字符，读到最后返回 -1
             * int read(char[] buffer):将字符读进字符数组,返回结果为读取的字符数
             * int read(char[] buffer,int off,int len):将读取的字符存储进字符数组 buffer，返回结果为读取的字符数，从索引 off 开始，长度为 len
             */
            // 4. 读取文件中的数据, 读到最后没有数据时，返回-1
            while ((length = in.read(data)) != -1) {
                // 5. 写出数据到目的地文件
                out.write(data, 0, length);
                System.out.println(data);
            }
        }
    }
}
