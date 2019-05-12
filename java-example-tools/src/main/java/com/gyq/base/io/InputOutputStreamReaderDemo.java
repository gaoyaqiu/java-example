package com.gyq.base.io;

import java.io.*;

/**
 * InputStreamReader 与 OutputStreamWriter 学习笔记.
 *
 * @author gaoyaqiu
 */
public class InputOutputStreamReaderDemo {

    public static void main(String[] args) throws IOException {
        File src = new File("/Users/gaoyaqiu/Downloads/bak/io/src.txt");
        File dest = new File("/Users/gaoyaqiu/Downloads/bak/io/dest.txt");

        try (Reader in = new InputStreamReader(new FileInputStream(src), "utf-8");
             Writer out = new OutputStreamWriter(new FileOutputStream(dest), "utf-8")) {

            int len;
            char[] data = new char[1024];
            while ((len = in.read(data)) != -1) {
                out.write(data, 0, len);
                System.out.println(data);
            }
        }
    }
}
