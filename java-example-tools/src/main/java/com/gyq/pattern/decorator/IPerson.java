package com.gyq.pattern.decorator;

/**
 * 老王买菜(被装饰的对象).
 *
 * @author gaoyaqiu
 * @date 2018/7/30
 */
public interface IPerson {

    /**
     * 计算消费总额
     * @return
     */
    double cost();

    /**
     * 显示买的所有菜
     */
    void show();
}
