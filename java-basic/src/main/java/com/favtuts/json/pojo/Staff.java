package com.favtuts.json.pojo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.favtuts.json.CompanyViews;

//ignore null fields , class level
//@JsonInclude(JsonInclude.Include.NON_NULL) 	//  ignore all null fields
public class Staff {

    public Staff(String name, int age, String[] position, List<String> skills, Map<String,BigDecimal> salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.skills = skills;
        this.salary = salary;
    }

    public Staff() {
    }
    
    //@JsonProperty("custom_name")
    @JsonView(CompanyViews.Normal.class)
    private String name;

    @JsonView(CompanyViews.Normal.class)
    private int age;
    
    @JsonView(CompanyViews.Manager.class)
    //@JsonInclude(JsonInclude.Include.NON_NULL) //ignore null field on this property only
    private String[] position;              //  Array

    @JsonIgnore
    //@JsonView(CompanyViews.Manager.class)
    private List<String> skills;            //  List

    @JsonIgnore
    //@JsonView(CompanyViews.Manager.class)
    private Map<String, BigDecimal> salary; //  Map

	// getters , setters, some boring stuff

    @Override
    public String toString() {
        return "Staff {" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", position='" + getPosition() + "'" +
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
