package com.favtuts.java8;

import java.math.BigDecimal;

public class Invoice {

    @Override
    public String toString() {
        return "Invoice{" +
            " no='" + getNo() + "'" +
            ", unitPrice='" + getUnitPrice() + "'" +
            ", qty='" + getQty() + "'" +
            "}";
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Invoice(String no, BigDecimal unitPrice, Integer qty) {
        this.no = no;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public Invoice() {
    }

    public Invoice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    String no;
    BigDecimal unitPrice;
    Integer qty;
}
