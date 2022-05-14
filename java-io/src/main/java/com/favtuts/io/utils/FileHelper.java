package com.favtuts.io.utils;

import java.io.InputStream;
import java.util.Properties;

public class FileHelper {

    public static void main(String[] args) {
        FileHelper obj = new FileHelper();
        System.out.println(obj.getFilePathToSave());
    }

    public String getFilePathToSave() {

        Properties prop = new Properties();        
        String result = "";

        try (InputStream inputStream = getClass().getClassLoader()
                                            .getResourceAsStream("config.properties")
        ) {
            prop.load(inputStream);
            result = prop.getProperty("json.filepath");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
}
