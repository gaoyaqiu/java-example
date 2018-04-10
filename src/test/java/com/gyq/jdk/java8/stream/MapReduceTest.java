package com.gyq.jdk.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * @auther gaoyaqiu
 */
public final class MapReduceTest {

    @Test
    public void test() {
        List<Car> list = Arrays.asList(new Car("java开发", 200, 58.5)
                , new Car("php开发", 100, 45.5)
                , new Car("go开发", 300, 66.6));

        // 获取购物车中书籍总价
        list.stream().map(myCar -> {
            System.out.print("书名: " + myCar.getName() + " 总价: ");
            return myCar.getAmount() * myCar.getPrice();
        }).forEachOrdered(System.out::println);

        System.out.println("-------------------------");

        double result = list.stream().map(myCar -> myCar.getAmount() * myCar.getPrice())
                .reduce((sum, carPrice) -> sum + carPrice)
                .get();
        System.out.println("购买总金额: " + result);

        System.out.println("-------------------------");

        DoubleSummaryStatistics doubleSummaryStatistics = list.stream().mapToDouble(myCar -> myCar.getAmount() * myCar.getPrice()).summaryStatistics();
        System.out.println("统计量: " + doubleSummaryStatistics.getCount());
        System.out.println("最大值: " + doubleSummaryStatistics.getMax());
        System.out.println("最小值: " + doubleSummaryStatistics.getMin());
        System.out.println("总和: " + doubleSummaryStatistics.getSum());
        System.out.println("平均值: " + doubleSummaryStatistics.getAverage());

    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Car {
        private String name;

        private Integer amount;

        private double price;
    }
}
