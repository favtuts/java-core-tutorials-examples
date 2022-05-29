package com.favtuts.java8;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Developer2 {
    
    String name;
    BigDecimal salary;
    LocalDate start;

    // for factory(Developer::new);
    public Developer2() {
    }

    // for factory(() -> new Developer("favtuts"));
    public Developer2(String name) {
        this.name = name;
    }

    // get, set, constructor, toString
    //...

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getStart() {
        return this.start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Developer{" +
            " name='" + getName() + "'" +
            ", salary='" + getSalary() + "'" +
            ", start='" + getStart() + "'" +
            "}";
    }
}
