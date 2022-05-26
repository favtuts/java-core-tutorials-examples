package com.favtuts.java8;

public class StaffPublic {

    private String name;
    private int age;
    private String extra;

    public StaffPublic(String name, int age, String extra) {
        this.name = name;
        this.age = age;
        this.extra = extra;
    }

    public StaffPublic() {
    }


    @Override
    public String toString() {
        return "StaffPublic{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", extra='" + getExtra() + "'" +
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

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }    
    
}
