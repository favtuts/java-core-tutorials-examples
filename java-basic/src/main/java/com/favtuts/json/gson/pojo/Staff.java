package com.favtuts.json.gson.pojo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Staff {

    private String name;
    private int age;
    private String[] position;              // array
    private List<String> skills;            // list
    private Map<String, BigDecimal> salary; // map

    public Staff(String name, int age) {
        this.name = name;
        this.age = age;        
    }

    public Staff() {
    }
    
    //getters and setters

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", position='" + Arrays.asList(getPosition()) + "'" +
            ", skills='" + getSkills() + "'" +
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

    public String[] getPosition() {
        return this.position;
    }

    public void setPosition(String[] position) {
        this.position = position;
    }

    public List<String> getSkills() {
        return this.skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Map<String,BigDecimal> getSalary() {
        return this.salary;
    }

    public void setSalary(Map<String,BigDecimal> salary) {
        this.salary = salary;
    }
    
}
