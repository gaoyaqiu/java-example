package com.gyq.base.io;

import java.io.*;

/**
 * FileInputStream 与 FileOutputStream 学习笔记.
 *
 * @author gaoyaqiu
 */
public class FileInputOutStreamDemo {

    public static void main(String[] args) throws IOException {
        // 1. 创建来源于目的地文件
        File src = new File("/Users/gaoyaqiu/Downloads/bak/io/src.txt");
        File dest = new File("/Users/gaoyaqiu/Downloads/bak/io/dest.txt");
        // 2. 自动关闭资源
        try(InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest)){
            // 3. 每次从来源文件读取 1024 字节
            byte[] data = new byte[1];
            int length;
            /**
             *  int read():读取一个字节，返回读取的字节
             *  int read(byte[] b):读取多个字节,并保存到数组 b 中，从数组 b 的索引为 0 的位置开始存储，返回读取了几个字节
             *  int read(byte[] b,int off,int len):读取多个字节，并存储到数组 b 中，从数组b 的索引为 0 的位置开始，长度为len个字节
             */
            // 4. 读取文件中的数据, 读到最后没有数据时，返回-1
            while ((length = in.read(data)) != -1) {
                // 5. 写出数据到目的地文件
                out.write(data, 0, length);
                System.out.println(new String(data));
            }
        }
    }
}
