package com.favtuts.java8;

public class Hosting {

    private int Id;
    private String name;
    private String url;

    public Hosting(int id, String name, String url) {
        Id = id;
        this.name = name;
        this.url = url;
    }

    //... getters and setters, toString()
    @Override
    public String toString() {
        return "Hosting{" +
            " Id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
