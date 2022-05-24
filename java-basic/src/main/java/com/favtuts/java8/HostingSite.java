package com.favtuts.java8;

public class HostingSite {

    private int Id;
    private String name;
    private long websites;

    public HostingSite(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }

    //getters, setters and toString()
    @Override
    public String toString() {
        return "Hosting{" +
            " Id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", websites='" + getWebsites() + "'" +
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

    public long getWebsites() {
        return this.websites;
    }

    public void setWebsites(long websites) {
        this.websites = websites;
    }
}