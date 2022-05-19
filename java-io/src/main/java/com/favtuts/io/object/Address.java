package com.favtuts.io.object;

import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    String street;
    String country;

    public Address(String street, String country) {
        this.street = street;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
