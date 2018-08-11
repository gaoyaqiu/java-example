package com.gyq.pattern.decorator;

/**
 * 装饰器模式（结构型设计模式）
 *
 * 特点: 有两个角色(装饰器、被装饰的对象)
 * 优点: 扩展灵活、每个装饰器相互独立，修改互不影响
 * 缺点: 有点类似递归嵌套，实现多次装饰的功能，比较复杂，无论装饰多少次，被装饰者永远都是装饰器类的子类型
 *
 * 案例：Java中的IO流设计就采用了装饰器模式，InputStream就是被装饰对象的超类，FileInputStream、StringBufferInputStream等
 * 就是被装饰对象，FilterInputStream以及其子类就是装饰器，比如：
 * DataInputStream in = new DataInputStream(new CharacterInputStream(new FileInputStream("test.txt")))
 * @author gaoyaqiu
 * @date 2018/7/30
 */
public class DecoratorMain {
    public static void main(String[] args) {
        IPerson laoWang = new LaoWang();

        laoWang = new Bread(laoWang);
        laoWang = new Vegetables(laoWang);

        laoWang.show();

        System.out.println("老王总共消费: " + laoWang.cost());

    }
}
