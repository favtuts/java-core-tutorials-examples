package com.favtuts.io.howto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;

public class PropertiesFileExamples {    
    public static void main(String[] args) {
        
        String userDirectory = Paths.get("")
            .toAbsolutePath()
            .toString();
        
        // path/to/config.properties
        String configFilePath = userDirectory + "/java-io/src/main/resources/config.properties";
        System.out.println(configFilePath);

        // Write to the properties file
        // writePropertiesFile(configFilePath);

        // Load a properties file
        // loadPropertiesFile(configFilePath);

        // Load a properties file from classpath
        // loadPropertiesFileClassPath("config.properties");

        // Prints everything from a properties file
        PropertiesFileExamples app = new PropertiesFileExamples();
        app.printAll("config.properties");
    }

    private void printAll(String resourceFileName) {

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(resourceFileName)) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find " + resourceFileName);
                return;
            }

            prop.load(input);

            // Java 8 , print key and values
            prop.forEach((key, value) -> System.out.println("Key : " + key + ", Value : " + value));

            // Get all keys
            prop.keySet().forEach(x -> System.out.println(x));

            Set<Object> objects = prop.keySet();

            /*Enumeration e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.out.println("Key : " + key + ", Value : " + value);
            }*/

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void loadPropertiesFileClassPath(String resourceFileName) {
        try (InputStream input = PropertiesFileExamples.class.getClassLoader().getResourceAsStream(resourceFileName)) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find " + resourceFileName);
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void loadPropertiesFile(String configFilePath) {
        try (InputStream input = new FileInputStream(configFilePath)) {
            
            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writePropertiesFile(String configFilePath)  {

        try (OutputStream output = new FileOutputStream(configFilePath)) {
            
            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("db.url", "localhost");
            prop.setProperty("db.user", "favtuts");
            prop.setProperty("db.password", "password");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
