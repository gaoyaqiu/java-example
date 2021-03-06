package com.gyq.base.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * ByteArrayInputStream 与 ByteArrayOutputStream 学习笔记.
 *
 * @author gaoyaqiu
 */
public class ByteArrayInputOutputStreamDemo {
    public static void main(String[] args) throws Exception {

        OutputStream out = new ByteArrayOutputStream();
        out.write("abcdefg".getBytes());

        byte[] bytes = ((ByteArrayOutputStream) out).toByteArray();
        InputStream in = new ByteArrayInputStream(bytes);

        int length;
        byte[] data = new byte[1024];
        while ((length = in.read(data)) != -1) {
            System.out.println(new String(data));
        }

        in.close();
        out.close();
    }
}
