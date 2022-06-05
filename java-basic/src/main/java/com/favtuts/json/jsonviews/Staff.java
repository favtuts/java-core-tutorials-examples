package com.favtuts.json.jsonviews;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonView;

public class Staff {

    @JsonView(CompanyViews.Normal.class)
    private String name;

    @JsonView(CompanyViews.Normal.class)
    private int age;

    // two views
    @JsonView({CompanyViews.HR.class, CompanyViews.Manager.class})
    private String[] position;

    @JsonView(CompanyViews.Manager.class)
    private List<String> skills;

    @JsonView(CompanyViews.HR.class)
    private Map<String, BigDecimal> salary;
      
    
    public Staff(String name, int age) {
        this.name = name;
        this.age = age;        
    }

    public Staff() {
    }

	// getters , setters , boring stuff

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
