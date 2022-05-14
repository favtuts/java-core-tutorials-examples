package com.favtuts.io.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileHelper {

    public static void main(String[] args) {
        
        // Non Static Method
        FileHelper obj = new FileHelper();
        System.out.println(obj.getFilePathToSave());

        // Static Method
        System.out.println(getFilePathToSaveStatic());
    }

    public String getFilePathToSave() {

        Properties prop = new Properties();        
        String result = "";

        try (InputStream inputStream = getClass().getClassLoader()
                                            .getResourceAsStream("config.properties")
        ) {
            prop.load(inputStream);
            result = prop.getProperty("json.filepath");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String getFilePathToSaveStatic() {

        Properties prop = new Properties();        
        String result = "";

        try (InputStream inputStream = FileHelper.class.getClassLoader()
                                            .getResourceAsStream("config.properties")
        ) {
            prop.load(inputStream);
            result = prop.getProperty("json.filepath");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
    
}
