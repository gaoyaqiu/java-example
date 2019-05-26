package com.gyq.base.process;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * @author gaoyaqiu
 */
public class ChildProcessDemo {
    public static void main(String[] args) throws IOException {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(operatingSystemMXBean.getName());
        // 我本地是Mac系统
        if (operatingSystemMXBean.getName().startsWith("Mac")) {
            // 打开工程目录
            Runtime.getRuntime().exec("open .");
        }
    }
}
