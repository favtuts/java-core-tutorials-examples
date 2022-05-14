package com.favtuts.io.howto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Properties;

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
        loadPropertiesFile(configFilePath);
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
