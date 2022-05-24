package com.favtuts.java8;

import java.math.BigDecimal;

public class Developer {

    @Override
    public String toString() {
        return "Developer [" +
            " name='" + getName() + "'" +
            ", salary='" + getSalary() + "'" +
            ", age='" + getAge() + "'" +           
            "]";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Developer(String name,  BigDecimal salary, int age) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    private String name;
    private int age;
    private BigDecimal salary;
}
