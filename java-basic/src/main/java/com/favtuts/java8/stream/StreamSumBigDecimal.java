package com.favtuts.java8.stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StreamSumBigDecimal {
    
    public static void main(String[] args) {
        //sumBigDecimalWithStreamReduce();
        sumBigDecimalWithStreamMapReduce();
    }

    static void sumBigDecimalWithStreamMapReduce() {
        List<Invoice> invoices = Arrays.asList(
                new Invoice("I1001", BigDecimal.valueOf(9.99), BigDecimal.valueOf(1)),
                new Invoice("I1002", BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5)),
                new Invoice("I1003", BigDecimal.valueOf(4.888), BigDecimal.valueOf(2)),
                new Invoice("I1004", BigDecimal.valueOf(4.99), BigDecimal.valueOf(5)),
                new Invoice("I1005", BigDecimal.valueOf(.5), BigDecimal.valueOf(2.3))
        );

        BigDecimal sum = invoices.stream()
                .map(x -> x.getQty().multiply(x.getPrice()))    // map
                .reduce(BigDecimal.ZERO, BigDecimal::add);      // reduce

        System.out.println(sum);    // 75.851
        System.out.println(sum.setScale(2, RoundingMode.HALF_UP));  // 75.85
    }

    static void sumBigDecimalWithStreamReduce() {
        List<BigDecimal> invoices = new LinkedList<>();
        invoices.add(BigDecimal.valueOf(9.9));
        invoices.add(BigDecimal.valueOf(1.0));
        invoices.add(BigDecimal.valueOf(19.99));
        invoices.add(BigDecimal.valueOf(0.2));
        invoices.add(BigDecimal.valueOf(5.5));

        // sum using a for loop
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal amt : invoices) {
            sum = sum.add(amt);
        }
        System.out.println("Sum = " + sum);

        // sum using stream
        BigDecimal sum2 = invoices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Sum (Stream) = " + sum2);
    }
}


class Invoice {

    String invoiceNo;
    BigDecimal price;
    BigDecimal qty;

    public Invoice(String invoiceNo, BigDecimal price, BigDecimal qty) {
        this.invoiceNo = invoiceNo;
        this.price = price;
        this.qty = qty;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
}