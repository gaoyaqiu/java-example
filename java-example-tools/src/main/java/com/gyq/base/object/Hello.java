package com.gyq.base.object;

/**
 * @author gaoyaqiu
 * @date 2018/7/17
 */
public class Hello {

    private int age = 18;

    private String name = "张三";

    public static void main(String[] args) {
        System.out.println(new Hello().toString());
    }

    @Override
    public String toString() {
        return "Hello{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
