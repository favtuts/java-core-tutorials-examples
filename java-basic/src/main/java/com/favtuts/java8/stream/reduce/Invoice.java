package com.favtuts.java8.stream.reduce;

import java.math.BigDecimal;

public class Invoice {
    
    String invoiceNo;
    BigDecimal price;
    BigDecimal qty;

    // getters, stters n constructor

    public Invoice() {
    }

    public Invoice(String invoiceNo, BigDecimal price, BigDecimal qty) {
        this.invoiceNo = invoiceNo;
        this.price = price;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "{" +
            " invoiceNo='" + getInvoiceNo() + "'" +
            ", price='" + getPrice() + "'" +
            ", qty='" + getQty() + "'" +
            "}";
    }

    public String getInvoiceNo() {
        return this.invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty() {
        return this.qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }   
}
