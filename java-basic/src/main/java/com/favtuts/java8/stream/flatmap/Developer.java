package com.favtuts.java8.stream.flatmap;

import java.util.HashSet;
import java.util.Set;

public class Developer {

    public Developer(Integer id, String name, Set<String> book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }

    public Developer() {
    }

    private Integer id;
    private String name;
    private Set<String> book;

    //getters, setters, toString

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBook() {
        return this.book;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Developer{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", book='" + getBook() + "'" +
            "}";
    }

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }
    
}
