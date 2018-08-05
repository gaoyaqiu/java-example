package com.gyq.base.object;

/**
 * @author gaoyaqiu
 * @date 2018/8/5
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        BMW bmw1 = new BMW(500000, "BMW");
        Car car1 = new Car(bmw1);

        Car car2 = (Car) car1.clone();
        // 两个对象地址不同，说明已经克隆成功了
        System.out.println("car1对象地址: " + car1);
        System.out.println("car2对象地址: " + car2);

        System.out.println("----------------------------------------");
        // 但是内部对象地址是一样的，说明这是浅拷贝
        System.out.println("bmw1对象地址: " + car1.getBmw());
        System.out.println("bmw2对象地址: " + car2.getBmw());

        // 浅拷贝特点是修改了某个对象的数据之后，会影响到另一个对象
        BMW bmw2 = car2.getBmw();
        bmw2.setName("Alto");
        bmw2.setPrice(30000);
        car2.setBmw(bmw2);

        // 修改了car2下的bmw2的数据，car1也变了
        System.out.println("bmw1的name为: " + car1.getBmw().getName());
        System.out.println("bmw2的name为: " + car2.getBmw().getName());
    }
}
