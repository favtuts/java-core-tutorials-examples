package com.favtuts.json.jsonarray;

public class Person {   

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
    String name;
    Integer age;

    //getters and setters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }
    
}
