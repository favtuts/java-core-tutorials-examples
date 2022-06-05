package com.favtuts.json.nullfields;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;


//ignore null fields , class level
//@JsonInclude(JsonInclude.Include.NON_NULL) 	//  ignore all null fields
public class Staff {

    private String name;
    private int age;

    //@JsonInclude(JsonInclude.Include.NON_NULL) //ignore null field on this property only
    private String[] position;
    
    //@JsonInclude(JsonInclude.Include.NON_NULL) //ignore null field on this property only
    private List<String> skills;

    private Map<String, BigDecimal> salary; 

    public Staff() {        
    }

    public Staff(String name, int age) {
        this.name = name;
        this.age = age;    
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
