package com.gyq.pattern.decorator;

/**
 * @author gaoyaqiu
 * @date 2018/7/30
 */
public class Bread extends FoodDecorator {

    public Bread(IPerson person) {
        super(person);
    }

    @Override
    public double cost() {
        return person.cost() + 100;
    }

    @Override
    public void show() {
        person.show();
        System.out.println("买了面包， 累计消费: " + this.cost());
    }
}
