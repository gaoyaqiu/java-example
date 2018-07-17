package com.gyq.base.object;

/**
 * @author gaoyaqiu
 * @date 2018/7/17
 */
public class ClassInfo {
    public static void main(String[] args) {
        Class cs = String.class;
        System.out.println("--------引用类型----------");
        System.out.println("类名: " + cs.getName());
        System.out.println("是否为接口: " + cs.isInterface());
        System.out.println("是否为基本类型: " + cs.isPrimitive());
        System.out.println("是否为数组对象: " + cs.isArray());
        System.out.println("父类名称: " + cs.getSuperclass().getName());

        System.out.println("--------基本类型----------");
        Class ci = Integer.TYPE;
        System.out.println("类名: " + ci.getName());
        System.out.println("是否为接口: " + ci.isInterface());
        System.out.println("是否为基本类型: " + ci.isPrimitive());
        System.out.println("是否为数组对象: " + ci.isArray());
        // 注：基本类型没有父类
        System.out.println("父类名称: " + ci.getSuperclass());
    }
}
