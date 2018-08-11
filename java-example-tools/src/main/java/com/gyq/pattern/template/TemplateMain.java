package com.gyq.pattern.template;

/**
 * 模板方法模式.
 *
 * 特点：当一个业务有N个子流程，其中一些流程是固定不变的，那么可以将这些不变的流程抽象到父类中，将可能变化的业务留给子类实现
 * 优点：将公共代码封装起来，易于维护，容易变化的部分由子类时间，易于扩展
 * 缺点：新增业务时，子类会越来越多
 * 案例：Servlet中的service方法就用了模板模式，内部根据不同的请求，如：get、post、head、delete等来选择调用不同的方法
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class TemplateMain {

    public static void main(String[] args) {
        LiftTemplate lift1 = new Work();
        lift1.process();

        System.out.println("=======================================");
        LiftTemplate lift2 = new Travel();
        lift2.process();
    }
}
