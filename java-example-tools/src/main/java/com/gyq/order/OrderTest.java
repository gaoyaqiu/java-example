package com.gyq.order;

import com.gyq.utils.DateUtil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;

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
     * 需要生成随机数的总个数
     * 注：该值从业务层面需要控制 <= 总的人次数
     */
    static final int RANDOM_NUM = 100;

    /**
     * 毫秒最大值
     */
    static final int MAX_MILLI = 999;

    /**
     * 固定值
     */
    static final int FIXED_VALUE = 10000001;

    static final int MIN_LUCKY_NUM = 10000002;
    static final int MAX_LUCKY_NUM = 19999999;

    public static void main(String[] args) {
        // 假设总需人次为 500
        int total = 500;

        // 获取随机 100 个订单的时间戳
        List<Long> randomOrderList = getRandomOrderList();

        // 自动
//        auto(total, randomOrderList);

        // 自定义
        long luckyNum = 10000168;
        List<Long> newList = custom(total, randomOrderList, luckyNum);
        auto(total, newList);
    }

    private static List<Long> custom(int total, List<Long> randomOrderList, long luckyNum) {
        if (luckyNum < MIN_LUCKY_NUM || luckyNum > MAX_LUCKY_NUM) {
            System.err.println("幸运号码格式范围有误！luckyNum: " + luckyNum);
            return Collections.emptyList();
        }

        // 获取实际的号码
        String str = String.valueOf(luckyNum);
        str = str.substring(str.lastIndexOf("0") + 1);
        // -1 是因为生成的号码规则从 1开始，而计算取余时从 0 开始
        long realNum = Long.parseLong(str) - 1;
        // 计算时、分、秒、毫秒 总和
        long sumNacos = getSumNacos(randomOrderList);
        // 将总纳秒格式化为时、分、秒、毫秒格式
        String strTime = formatDateTime(sumNacos);
        long oldMilli = sumNacos / NANOS_PER_MILLI;
        System.out.println(String.format("统计订单总纳秒数为：%d,转换为毫秒为：%d", sumNacos, oldMilli));
        System.out.println("将总纳秒格式化为时间： " + strTime);
        // 格式化时间得到数值 A
        String fmtValue = strTime.replaceAll(":", "").replace(".", "");
        long a1 = Long.parseLong(fmtValue);
        System.out.println("指定号码之前，A1 计算结果为：" + a1 % total);
        System.out.println("============================================");
        int orderTotal = RANDOM_NUM <= total ? RANDOM_NUM : total;
        // 指定号码计算公式： 除数 * 商（在老的时间戳基础上增加自定义毫秒数(MAX_MILLI * orderTotal / 2)） + 余数（指定号码） = 被除数
        long a2 = total * ((oldMilli + MAX_MILLI * orderTotal / 2) / total) + realNum;
        System.out.println("指定号码之后，A2为： " + a2);
        System.out.println("指定号码之后，A2 计算结果为：" + a2 % total);
//        // 计算最终结果 -1 是因为指定号码时实际 luckyNum 值应该是(luckyNum - 1)，因为生成的规则做了 +1 操作
        long result = a2 % total + FIXED_VALUE - 1;
        System.out.println("指定号码之后，最终结果为：" + result);
        int v = (int) (a2 - oldMilli);
        System.out.println("指定号码之后, 毫秒相差: " + v);
        // 重新填充新的时间格式
        List<Long> newList = setOrderTime(orderTotal, v, randomOrderList);
        return newList;
    }

    private static List<Long> setOrderTime(int orderTotal, int total, List<Long> randomOrderList) {
        // 获取随机毫秒数
        GenerateRandomNum generateRandomNum = new GenerateRandomNum();
        List<Integer> milliList = generateRandomNum.getRandomNum(orderTotal, total);
        System.out.println(milliList);
        System.out.println("生成的随机毫秒数总和：" + milliList.stream().reduce((x, y) -> x + y).get());
        // 7. 将生成的随机毫秒数重新填充到源时间中
        List<Long> newList = newArrayList();
        for (int i = 0; i < randomOrderList.size(); i++) {
            newList.add(randomOrderList.get(i) + milliList.get(i));
        }
        System.out.println("填充之后结果如下：");
        newList.stream().forEach(newTime -> System.out.println(DateUtil.convertTimeToStringMilli(newTime)));

        return newList;
    }

    private static void auto(int total, List<Long> randomOrderList) {
        // 计算时、分、秒、毫秒 总和
        long sumNacos = getSumNacos(randomOrderList);
        System.out.println(String.format("统计订单总纳秒数为：%d,转换为毫秒为：%d", sumNacos, sumNacos / NANOS_PER_MILLI));
        // 将总纳秒格式化为时、分、秒、毫秒格式
        String strTime = formatDateTime(sumNacos);
        System.out.println("将总纳秒格式化为时间： " + strTime);
        // 格式化时间得到数值 A
        String fmtValue = strTime.replaceAll(":", "").replace(".", "");
        long a = Long.parseLong(fmtValue);
        System.out.println("计算得出数值A为： " + a);
        //  计算结果  +1 是因为要和码生成规则保持一致，取余从 0 开始，而码是从 1 开始生成
        long result = (a % total) + 1 + FIXED_VALUE;
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
     * 获取随机订单
     *
     * @return
     */
    private static List<Long> getRandomOrderList() {
        List<Long> randomOrderList = newArrayList();
        for (int i = 0; i < RANDOM_NUM; i++) {
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

}
