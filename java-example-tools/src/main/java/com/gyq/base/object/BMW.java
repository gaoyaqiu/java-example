package com.gyq.base.object;

/**
 * @author gaoyaqiu
 * @date 2018/8/5
 */
public class BMW implements Cloneable {

    private double price;

    private String name;

    public BMW(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String display() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"price\":")
                .append(price);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
