package com.gyq.base.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * CharArrayReader 与 CharArrayWriter 学习笔记.
 *
 * @author gaoyaqiu
 */
public class CharArrayReaderWriterDemo {

    public static void main(String[] args) throws Exception {
        // 初始化写入字符数的大小
        Writer out = new CharArrayWriter(1024);
        out.write("111你好啊2333abc");

        char[] chars = ((CharArrayWriter) out).toCharArray();
        Reader in = new CharArrayReader(chars);
        int length;
        char[] data = new char[1024];
        while ((length = in.read(data)) != -1) {
            System.out.println(data);
        }

        in.close();
        out.close();
    }
}
