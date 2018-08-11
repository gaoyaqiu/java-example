package com.gyq.pattern.adapter;

/**
 * 适配器模式（结构型设计模式）.
 *
 * 特点: 适用于解决新旧系统(新旧接口)之间的兼容问题，不建议一开始就直接使用
 * 优点: 可以让两个不相干的类一起运行，无需修改旧代码，灵活性较好
 * 缺点: 适配器模式用多了会使整个系统变得很复杂，因为调用的是适配器，不清楚适配器内部做了多少转换操作，如果有更好的解决方案
 * 时，尽量少用适配器模式。
 *
 * @author gaoyaqiu
 * @date 2018/8/6
 */
public class AdapterMain {

    public static void main(String[] args) {
        MusicPlayer player = new PlayerAdapter();
        player.play("mp3", "hello.mp3");
        player.play("wma", "hello.wma");
    }
}
