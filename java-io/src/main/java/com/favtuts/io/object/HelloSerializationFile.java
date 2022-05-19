package com.favtuts.io.object;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

public class HelloSerializationFile {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person = new Person("favtuts", 50, new BigDecimal(1000));

        File file = new File("person.bin");

        writeObjectToFile(person, file);

        Person p = readObjectFromFile(file);

        System.out.println(p);

    }

    // Serialization
    // Save object into a file
    public static void writeObjectToFile(Person obj, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
            oos.flush();
        }
    }

    // Serialization
    // Convert object to OutputStream
    public static void writeObjectToStream(Object obj, OutputStream output) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(output)) {
            oos.writeObject(obj);
            oos.flush();
        }
    }

    // Serialization
    // Convert object to byte[]
    public static byte[] writeObjectToStream(Object obj) {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
            ois.writeObject(obj);
            return boas.toByteArray();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        throw new RuntimeException();
    }

    // Deserialization
    // Get object from a file
    public static Person readObjectFromFile(File file) throws IOException, ClassNotFoundException {
        Person result = null;
        try (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Person) ois.readObject();
        }
        return result;
    }

    // Deserialization
    // Get object from a file.
    public static Object readObjectFromFile2(File file) throws IOException, ClassNotFoundException {
        Object result = null;
        try (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = ois.readObject();
        }
        return result;
    }

    // Deserialization
    // Generic example
    @SuppressWarnings("unchecked")
    public static <T> T readObject(InputStream is, Class<T> anyClass) throws IOException, ClassNotFoundException {
        T result = null;
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            result = (T) ois.readObject();
        }
        return result;
    }

    // Deserialization
    // Convert object to byte[]
    public static byte[] convertObjectToBytes(Object obj) {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
            ois.writeObject(obj);
            return boas.toByteArray();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        throw new RuntimeException();
    }
}
