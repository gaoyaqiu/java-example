package com.gyq.base.io;

import java.io.*;

/**
 * BufferedInputStream 与 BufferedOutputStream 学习笔记.
 *
 * @author gaoyaqiu
 */
public class BufferedInputOutPutStreamDemo {

    private static int DEFAULT_BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        File src = new File("/Users/gaoyaqiu/Downloads/bak/io/src_char.txt");
        File dest = new File("/Users/gaoyaqiu/Downloads/bak/io/dest_char.txt");

        try (InputStream in = new BufferedInputStream(new FileInputStream(src), DEFAULT_BUFFER_SIZE);
             OutputStream out = new BufferedOutputStream(new FileOutputStream(dest), DEFAULT_BUFFER_SIZE)) {

            int length;
            byte[] data = new byte[1024];
            while ((length = in.read(data)) != -1) {
                out.write(data, 0, length);
                System.out.println(new String(data, "utf-8"));
            }
        }
    }
}
