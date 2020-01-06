package com.gyq.order;

import com.gyq.utils.DateUtil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;


public class OrderTest {

    /**
     * Seconds per minute.
     */
    static final int SECONDS_PER_MINUTE = 60;

    /**
     * Minutes per hour.
     */
    static final int MINUTES_PER_HOUR = 60;

    /**
     * Nanos per second.
     */
    static final long NANOS_PER_SECOND = 1000_000_000L;

    /**
     * Nanos per milli.
     */
    static final long NANOS_PER_MILLI = 1000_000L;

    /**
     * Nanos per minute.
     */
    static final long NANOS_PER_MINUTE = NANOS_PER_SECOND * SECONDS_PER_MINUTE;

    /**
     * Nanos per hour.
     */
    static final long NANOS_PER_HOUR = NANOS_PER_MINUTE * MINUTES_PER_HOUR;

    /**
     * 固定值
     */
    static final int FIXED_VALUE = 10000001;

    public static void main(String[] args) {
        // 假设总需人次为 500
        int total = 500;

        // 自动
        //  automatic(total);

        // 自定义
//        long luckyNumber = 10000332;
        long luckyNum = 180;
//        custom(total, luckyNum);

        // 生成随机数
        GenerateRandomNum generateRandomNum = new GenerateRandomNum();
        generateRandomNum.remainNum = 2;
        generateRandomNum.remainTotal = 50050;

        while (generateRandomNum.remainNum != 0) {
            System.out.println(getRandomNum(generateRandomNum) + "   ");
        }
    }

    private static void custom(int total, long luckyNum) {
        // 1. 获取随机 100 个订单的时间戳
        List<Long> randomOrderList = getRandomOrderList();
        // 2. 计算时、分、秒、毫秒 总和
        long sumNacos = getSumNacos(randomOrderList);
        // 3. 将总纳秒格式化为时、分、秒、毫秒格式
        String strTime = formatDateTime(sumNacos);
        System.out.println(String.format("统计订单总纳秒数为：%d,转换为毫秒为：%d", sumNacos, sumNacos / NANOS_PER_MILLI));
        System.out.println("将总纳秒格式化为时间： " + strTime);
        // 4. 格式化时间得到数值 A
        String fmtValue = strTime.replaceAll(":", "").replace(".", "");
        long a = Long.valueOf(fmtValue);
        System.out.println("计算得出数值A为： " + a);
        System.out.println("指定号码之前，计算结果为：" + a % total);
        // 指定号码
        long a2 = total * ((a + 50000) / total) + luckyNum;
        System.out.println("指定号码之后，A为： " + a2);
        System.out.println("指定号码之后计算结果为：" + a2 % total);
        System.out.println("A 相差: " + (a2 - a));
        // 5. 计算结果
//        long result = a % total + FIXED_VALUE;
    }

    private static void automatic(int total) {
        // 1. 获取随机 100 个订单的时间戳
        List<Long> randomOrderList = getRandomOrderList();
        // 2. 计算时、分、秒、毫秒 总和
        long sumNacos = getSumNacos(randomOrderList);
        System.out.println("汇总订单总纳秒数为：" + sumNacos);
        // 3. 将总纳秒格式化为时、分、秒、毫秒格式
        String strTime = formatDateTime(sumNacos);
        System.out.println("将总纳秒格式化为时间： " + strTime);
        // 4. 格式化时间得到数值 A
        String fmtValue = strTime.replaceAll(":", "").replace(".", "");
        long a = Long.valueOf(fmtValue);
        System.out.println("计算得出数值A为： " + a);
        // 5. 计算结果
        long result = a % total + FIXED_VALUE;
        System.out.println("计算结果为：" + result);
    }

    private static long getSumNacos(List<Long> randomOrderList) {
        return randomOrderList.stream().map(milli -> {
            LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(milli), ZoneId.systemDefault());
            LocalTime localTime = localDateTime.toLocalTime();

            long nanosPerHour = localTime.getHour() * NANOS_PER_HOUR;
            long nanosPerMinute = localTime.getMinute() * NANOS_PER_MINUTE;
            long nanosPerSecond = localTime.getSecond() * NANOS_PER_SECOND;
            long nacos = localTime.getNano();
//            System.out.println(String.format("nanosPerHour=%d,nanosPerMinute=%d,nanosPerSecond=%d,nacos=%d",
//                    nanosPerHour,
//                    nanosPerMinute,
//                    nanosPerSecond,
//                    nacos
//            ));
            long sum = nanosPerHour + nanosPerMinute + nanosPerSecond + nacos;
            // System.out.println(String.format("时间【%s】计算总的纳秒数为：%d", localTime, sum));
            return sum;
        }).reduce((sum, nanos) -> sum + nanos).get();
    }


    /**
     * 将纳秒换算成时、分、秒、毫秒格式（22:10:30.666）
     *
     * @param sumNacos
     * @return
     */
    private static String formatDateTime(long sumNacos) {
        if (sumNacos <= 0) {
            return "";
        }
        int hour = (int) (sumNacos / NANOS_PER_HOUR);
        int minute = (int) ((sumNacos / NANOS_PER_MINUTE) % MINUTES_PER_HOUR);
        int second = (int) ((sumNacos / NANOS_PER_SECOND) % SECONDS_PER_MINUTE);
        int millis = (int) ((sumNacos / NANOS_PER_MILLI) % 1000);

        StringBuilder sb = new StringBuilder();
        if (hour > 0) {
            sb.append(hour).append(":")
                    .append(minute).append(":")
                    .append(second).append(".")
                    .append(millis);
        } else if (minute > 0) {
            sb.append(minute).append(":")
                    .append(second).append(".")
                    .append(millis);
        } else if (second > 0) {
            sb.append(second).append(".").append(millis);
        } else {
            return String.valueOf(millis);
        }

        return sb.toString();
    }

    /**
     * 获取随机的 100 笔订单
     *
     * @return
     */
    private static List<Long> getRandomOrderList() {
        List<Long> randomOrderList = newArrayList();
        for (int i = 0; i < 100; i++) {
            long dt = getRandomTimestamp("2020-01-03 00:00:00", "2020-01-03 23:59:59");
            // 过滤掉毫秒部分
            String tmpStr = DateUtil.convertTimeToString(dt);
            LocalDateTime localDateTime = DateUtil.parseLocalDateTime(tmpStr);
            long convertDt = DateUtil.toEpochMilli(localDateTime);
            System.out.println(DateUtil.convertTimeToStringMilli(convertDt));
            randomOrderList.add(convertDt);
        }

        return randomOrderList;
    }

    /**
     * 获取指定时间段内的随机时间戳
     *
     * @param beginDateTime
     * @param endDateTime
     * @return
     */
    private static long getRandomTimestamp(String beginDateTime, String endDateTime) {
        LocalDateTime startTime = DateUtil.parseLocalDateTime(beginDateTime);
        LocalDateTime endTime = DateUtil.parseLocalDateTime(endDateTime);

        long startMilli = DateUtil.toEpochMilli(startTime);
        long endMilli = DateUtil.toEpochMilli(endTime);
        if (startMilli >= endMilli) {
            return 0L;
        }
        return generateRandomTs(startMilli, endMilli);
    }

    private static long generateRandomTs(long begin, long end) {
        long res = begin + (long) (Math.random() * (end - begin));
        if (res == begin || res == end) {
            System.out.println(String.format("重新生成：res=%d,begin=%d,end=%d", res, begin, end));
            return generateRandomTs(begin, end);
        }
        return res;
    }

    /**
     * 生成随机数
     *
     * @param generateRandomNum
     * @return
     */
    private static int getRandomNum(GenerateRandomNum generateRandomNum) {
        // 最后一个
        if (generateRandomNum.remainNum == 1) {
            generateRandomNum.remainNum--;
            return generateRandomNum.remainTotal;
        }
        // 限制最小数
        int min = 50;
        // 限制最大数
        int max = generateRandomNum.remainTotal / generateRandomNum.remainNum * 2;
        Random random = new Random();
        int num = random.nextInt() * max;
        num = num <= min ? 50 : num;

        generateRandomNum.remainNum--;
        generateRandomNum.remainTotal -= num;
        return num;
    }

    static class GenerateRandomNum {
        /**
         * 待生成的，剩余个数
         */
        private int remainNum;

        /**
         * 剩余总数
         */
        private int remainTotal;
    }
}
