package com.gyq.base.io;

import java.io.*;

/**
 * BufferedReader 与 BufferedWriter 学习笔记.
 *
 * @author gaoyaqiu
 */
public class BufferedReaderWriterDemo {

    public static void main(String[] args) throws IOException {
        File src = new File("/Users/gaoyaqiu/Downloads/bak/io/src.txt");
        File dest = new File("/Users/gaoyaqiu/Downloads/bak/io/dest.txt");

        try (Reader in = new BufferedReader(new FileReader(src));
             Writer out = new BufferedWriter(new FileWriter(dest))) {

            int len;
            char[] data = new char[1024];
            while ((len = in.read(data)) != -1) {
                out.write(data, 0, len);
                System.out.println(data);
            }
        }
    }
}
