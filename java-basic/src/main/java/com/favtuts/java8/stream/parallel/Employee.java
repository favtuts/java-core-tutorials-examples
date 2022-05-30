package com.favtuts.java8.stream.parallel;

import java.io.Serializable;
import java.math.BigDecimal;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private BigDecimal salary;

    //getters, setters n etc...

    public Employee(String name, int age, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", salary='" + getSalary() + "'" +
            "}";
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

}
