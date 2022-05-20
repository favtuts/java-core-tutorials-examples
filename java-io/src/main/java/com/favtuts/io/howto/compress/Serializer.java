package com.favtuts.io.howto.compress;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.GZIPOutputStream;

import com.favtuts.io.object.Address;

public class Serializer implements Serializable {

    public static void main(String[] args) {
        Serializer serializer = new Serializer();
        serializer.serializeAddress("Wall street", "United State");
    }
    
    public void serializeAddress(String street, String country) {

        Address address = new Address();
        address.setStreet(street);
        address.setCountry(country);

        try {
            FileOutputStream fos = new FileOutputStream("/home/tvt/workspace/favtuts/address.gz");
            GZIPOutputStream gz = new GZIPOutputStream(fos);

            ObjectOutputStream oos = new ObjectOutputStream(gz);

            oos.writeObject(address);
            oos.close();

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
