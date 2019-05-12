package com.gyq.base.io;

import java.io.*;

/**
 * BufferedInputStream 与 BufferedOutputStream 学习笔记.
 *
 * @author gaoyaqiu
 */
public class BufferedInputOutPutStreamDemo {

    public static void main(String[] args) throws IOException {
        File src = new File("/Users/gaoyaqiu/Downloads/bak/io/src.txt");
        File dest = new File("/Users/gaoyaqiu/Downloads/bak/io/dest.txt");

        try (InputStream in = new BufferedInputStream(new FileInputStream(src));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {

            int length;
            byte[] data = new byte[1024];
            while ((length = in.read(data)) != -1) {
                out.write(data, 0, length);
                System.out.println(new String(data, "utf-8"));
            }
        }
    }
}
