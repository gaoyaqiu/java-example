package com.gyq.base.object;

import java.util.Objects;

/**
 * @author gaoyaqiu
 * @date 2018/8/1
 */
public class Girl extends Person {

    private int classId;


    public Girl(String name, int age, int classId) {
        super(name, age);
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        if (!super.equals(o)) {
            return false;
        }

        Girl girl = (Girl) o;
        return classId == girl.classId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), classId);
    }

    public static void main(String[] args) {
        Person p1 = new Person("张三", 20);
        Person p2 = new Person("张三", 20);

        Girl girl = new Girl("张三", 20, 12);
        Girl girl2 = new Girl("张三", 20, 12);

        System.out.println(p1.equals(p2));

        System.out.println(girl.equals(girl2));
    }
}
