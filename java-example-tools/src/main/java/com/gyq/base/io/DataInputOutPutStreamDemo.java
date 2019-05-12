package com.gyq.base.io;

import java.io.*;

/**
 * DataInputStream 与 DataOutputStream 学习笔记.
 *
 * @author gaoyaqiu
 */
public class DataInputOutPutStreamDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/gaoyaqiu/Downloads/bak/io/data.txt");

        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            out.writeDouble(123.45);
            out.writeInt(666);
            out.writeBoolean(true);
            out.writeFloat(999);
            out.writeLong(333L);
            out.writeUTF("你好啊");
            out.writeUTF("hello");
        }

        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            System.out.println(in.readDouble());
            System.out.println(in.readInt());
            System.out.println(in.readBoolean());
            System.out.println(in.readFloat());
            System.out.println(in.readLong());
            System.out.println(in.readUTF());
            System.out.println(in.readUTF());
        }
    }
}
