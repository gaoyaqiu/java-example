package com.gyq.order;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author qiu
 */
public class GenerateRandomNum {

    /**
     * 生成的毫秒数最小值
     */
    private static final int MIN_VALUE = 50;

    /**
     * 生成的毫秒数最大值
     */
    private static final int MAX_VALUE = 906;

    public List<Integer> getRandomNum(int count, int total) {
        List<Integer> list = newArrayList();

        // 限制生成的毫秒最大值为平均值的 2 倍，防止生成的某一个值较大
        int max = total / count * 2;
        // 限制每一次生成的最大值
        max = max > MAX_VALUE ? MAX_VALUE : max;

        for (int i = 0; i < count; i++) {
            int randomValue = generateRandomNum(count - i, total, MIN_VALUE, max);
            list.add(randomValue);
            // 每生成一次，总数减少
            total -= randomValue;
        }

        return list;
    }

    /**
     * 生成指定范围内的随机值
     *
     * @param count 总个数
     * @param total 总数之和
     * @param minV  最小值
     * @param maxV  最大值
     * @return
     */
    private int generateRandomNum(int count, int total, int minV, int maxV) {
        // 只生成一个
        if (count == 1) {
            return total;
        }
        // 如果最大最小值相同，直接返回
        if (minV == maxV) {
            return minV;
        }
        int max = maxV > total ? total : maxV;
        int maxY = total - (count - 1) * minV;
        int minY = total - (count - 1) * maxV;
        // 限制随机生成的最小值
        int min = minY > minV ? minY : minV;
        // 限制随机生成的最大值
        max = maxY < max ? maxY : max;

        return (int) (Math.random() * (max - min)) + min;
    }
}
