package com.favtuts.java8.stream.grouping;

import java.math.BigDecimal;

public class Item {

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public Item() {
    }
    private String name;
    private int qty;
    private BigDecimal price;

    //constructors, getter/setters

    @Override
    public String toString() {
        return "Item{" +
            " name='" + getName() + "'" +
            ", qty='" + getQty() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
