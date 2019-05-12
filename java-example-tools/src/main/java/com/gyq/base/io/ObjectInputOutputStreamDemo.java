package com.gyq.base.io;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.*;

/**
 * ObjectInputStream 与 ObjectOutputStream 学习笔记.
 *
 * @author gaoyaqiu
 */
public class ObjectInputOutputStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("/Users/gaoyaqiu/Downloads/bak/io/object.txt");

        User user = new User("张三疯", 118);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(user);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            User u = (User) in.readObject();
            System.out.println(u.getName());
            System.out.println(u.getAge());
        }

    }

    @Getter
    @AllArgsConstructor
    static class User implements Serializable {
        private static final long serialVersionUID = -5960638734567192631L;
        private String name;

        private int age;
    }
}
