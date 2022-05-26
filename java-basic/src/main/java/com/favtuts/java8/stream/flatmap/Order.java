package com.favtuts.java8.stream.flatmap;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    public Order(Integer id, String invoice, List<LineItem> lineItems, BigDecimal total) {
        this.id = id;
        this.invoice = invoice;
        this.lineItems = lineItems;
        this.total = total;
    }

    public Order() {
    }

    private Integer id;
    private String invoice;
    private List<LineItem> lineItems;
    private BigDecimal total;

    // getter, setters, constructor

    @Override
    public String toString() {
        return "Order{" +
            " id='" + getId() + "'" +
            ", invoice='" + getInvoice() + "'" +
            ", lineItems='" + getLineItems() + "'" +
            ", total='" + getTotal() + "'" +
            "}";
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoice() {
        return this.invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public List<LineItem> getLineItems() {
        return this.lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
}
