package com.gyq.base.io;

import java.io.*;

/**
 * PrintStream 与 PrintWriter 学习笔记.
 *
 * @author gaoyaqiu
 */
public class PrintStreamWriterDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/gaoyaqiu/Downloads/bak/io/print.txt");

        printWriter(file);

        read(file);

        System.out.println("==================");

        printStream(file);

        read(file);
    }

    private static void read(File file) throws IOException {
        try (Reader in = new BufferedReader(new FileReader(file))) {
            int len;
            char[] data = new char[50];
            while ((len = in.read(data)) != -1) {
                System.out.println(String.valueOf(data));
            }
        }
    }

    private static void printWriter(File file) throws FileNotFoundException {

        try (PrintWriter out = new PrintWriter(file)) {
            out.print("111");
            out.write("好啊");
            out.println("张三疯");
        }
    }

    private static void printStream(File file) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(file)) {
            out.println(123);
            out.printf("%s", "hello world");
        }

    }
}
