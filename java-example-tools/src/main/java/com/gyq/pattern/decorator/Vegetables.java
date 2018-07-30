package com.gyq.pattern.decorator;

/**
 * @author gaoyaqiu
 * @date 2018/7/30
 */
public class Vegetables extends FoodDecorator {
    public Vegetables(IPerson person) {
        super(person);
    }

    @Override
    public double cost() {
        return person.cost() + 200;
    }

    @Override
    public void show() {
        person.show();
        System.out.println("买了蔬菜， 累计消费: " + this.cost());
    }
}
