package com.favtuts.io.object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectUtils {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Address address = new Address("abc", "Malaysia");

        // object -> file
        try (FileOutputStream fos = new FileOutputStream("address.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(address);
            oos.flush();
        }

        Address result = null;
        // file -> object
        try (FileInputStream fis = new FileInputStream("address.obj");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Address) ois.readObject();
        }

        System.out.println(result);

    }
}
