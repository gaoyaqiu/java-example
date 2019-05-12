package com.gyq.base.io;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * SequenceInputStream 合并流学习笔记.
 *
 * @author gaoyaqiu
 */
public class SequenceInputStreamDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream f1 = new FileInputStream("/Users/gaoyaqiu/Downloads/bak/io/src.txt");
        FileInputStream f2 = new FileInputStream("/Users/gaoyaqiu/Downloads/bak/io/hello.txt");

        Vector<FileInputStream> v = new Vector<FileInputStream>();
        v.addElement(f1);
        v.addElement(f2);
        Enumeration<FileInputStream> em = v.elements();

        SequenceInputStream sis = new SequenceInputStream(em);

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("/Users/gaoyaqiu/Downloads/bak/io/sis.txt"));
        int len;
        byte[] data = new byte[1024];
        while ((len = sis.read(data)) != -1) {
            out.write(data, 0, len);
            System.out.println(new String(data));
        }

        out.close();
        sis.close();
    }
}
