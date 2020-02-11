package com.gyq.jdk;

/**
 * @author gaoyaqiu
 */
public class TryCatchFinallyTest {

    public static void main(String[] args) {
        try {
            System.out.println("try...");
            if (true) {
                throw new RuntimeException("try exception");
            }
        } catch (Exception e) {
            System.out.println("catch....");
            System.out.println(e.getMessage());
            if (true) {
                throw new RuntimeException("catch exception");
            }
        } finally {
            System.out.println("final...");
        }
    }
}
