package com.gyq.base.process;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author gaoyaqiu
 */
public class ProcessInfoDemo {

    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 获取操作系统信息，比如：架构、核心负载等信息
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

        Instant instant = Instant.ofEpochMilli(runtimeMXBean.getStartTime());
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("当前进程启动时间：" + zonedDateTime);
        System.out.println("当前进程上线时间：" + runtimeMXBean.getUptime());
        System.out.println("当前进程的线程数量：" + threadMXBean.getThreadCount());

        // 内存使用情况
        ManagementFactory.getMemoryManagerMXBeans().forEach(memoryManagerMXBean -> {
            System.out.println(memoryManagerMXBean.getName());
        });

        // 退出当前 JVM 进程
        System.exit(0);
    }
}
