package com.gyq.learning.functional;

/**
 * annotation@author gaoyaqiu
 * @date 2019/2/24
 */
@DemoAnnotation(value = "Hello World")
public class DemoAnnotationDemo {

    public static void main(String[] args) {
        DemoAnnotation annotation = DemoAnnotationDemo.class.getAnnotation(DemoAnnotation.class);
        System.out.println(annotation.value());
    }
}
