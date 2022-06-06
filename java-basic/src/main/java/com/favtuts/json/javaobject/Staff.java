package com.favtuts.json.javaobject;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Staff {

    private String name;
    private int age;
    private String[] position;              //  Array
    private List<String> skills;            //  List
    private Map<String, BigDecimal> salary; //  Map

    public Staff(String name, int age) {
        this.name = name;
        this.age = age;        
    }

    public Staff() {
    }   

	// getters , setters, some boring stuff

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


    @Override
    public String toString() {
        return "Staff{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", position='" + getPosition() + "'" +
            ", skills='" + getSkills() + "'" +
            ", salary='" + getSalary() + "'" +
            "}";
    }

}
