package com.favtuts.java8.stream.flatmap;

import java.math.BigDecimal;

public class LineItem {

    public LineItem(Integer id, String item, Integer qty, BigDecimal price, BigDecimal total) {
        this.id = id;
        this.item = item;
        this.qty = qty;
        this.price = price;
        this.total = total;
    }

    public LineItem() {
    }
    
    private Integer id;
    private String item;
    private Integer qty;
    private BigDecimal price;
    private BigDecimal total;

    // getter, setters, constructor

    @Override
    public String toString() {
        return "LineItem{" +
            " id='" + getId() + "'" +
            ", item='" + getItem() + "'" +
            ", qty='" + getQty() + "'" +
            ", price='" + getPrice() + "'" +
            ", total='" + getTotal() + "'" +
            "}";
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }    
    
}
