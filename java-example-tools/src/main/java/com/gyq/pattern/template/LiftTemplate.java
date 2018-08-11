package com.gyq.pattern.template;

/**
 * 模板方法模式
 * <p>
 * 现实生活中每人都离不开吃饭、睡觉、排泄、工作或者旅游（土豪或者财务自由的人并不需要工作）
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public abstract class LiftTemplate {


    private final void eat() {
        System.out.println("开始吃饭。。。");
    }

    /**
     * 执行其它业务，如：上班、旅游等 供子类实现
     */
    public abstract void exeTask();


    private final void excrete() {
        System.out.println("开始排泄。。。");
    }

    private final void sleep() {
        System.out.println("开始睡觉。。。");
    }

    /**
     * 执行全套流程
     */
    public final void process() {
        eat();

        exeTask();

        excrete();

        sleep();
    }
}
