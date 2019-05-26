package com.gyq.base.process;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author gaoyaqiu
 */
public class ProcessIdDemo {
    public static void main(String[] args) {
        // Java 9 之前实现
        getProcessIdInLegacyWay();

    }

    private static void getProcessIdInLegacyWay() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        // 4837@localhost
        String name = runtimeMXBean.getName();
        String pid = name.substring(0, name.indexOf("@"));
        System.out.println("[Java 9 之前的方法]当前进程 ID: " + pid);
    }
}
