package com.gyq.base.object;

import java.util.Objects;

/**
 * @author gaoyaqiu
 * @date 2018/8/1
 */
public class Person {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }


    public static void main(String[] args) {

        Person p1 = new Person("张三", 20);
        Person p2 = new Person("张三", 20);

        System.out.println("p1 equals p2 结果为: " + p1.equals(p2));

        System.out.println("p1的hashCode为: " + p1.hashCode());
        System.out.println("p2的hashCode为: " + p2.hashCode());
    }
}
