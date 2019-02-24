package com.gyq.learning.functional;

/**
 * @author gaoyaqiu
 * @date 2019/2/21
 */
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        Function1 function1 = () -> {

        };

        FunctionalInterfaceWithoutAnnotation f2 = () -> {

        };
    }

    @FunctionalInterface
    public interface Function1 {
        void execute();

        // 不能出现两次抽象方法定义
        //void execute2();

        default String getDescription() {
            return null;
        }
    }

    public interface FunctionalInterfaceWithoutAnnotation {
        void execute();
    }
}
