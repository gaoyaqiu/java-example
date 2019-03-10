package com.gyq.test.jdk.base.enumtest;

import java.io.Serializable;

/**
 * @author gaoyaqiu
 * @date 2019/3/10
 */
public class EnumTest {

    public static void main(String[] args) {
        Subclass s1 = new Subclass();
        s1.foo(); //line 7

        Super s = new Subclass();
    }
}

interface Foo {
    int x = 10;
}

enum Enum01 implements Serializable {
    SUCCESS, ERROR;
}

class Super {
    private void foo() {
        System.out.println("Super");
    }
}

class Subclass extends Super {
    public void foo() {
        System.out.println("Subclass");
    }
}