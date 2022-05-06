package com.favtuts.io.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.favtuts.io.utils.ResourceHelper;

public class ReadFile3 {
    
    public static void main(String[] args) throws IOException {
        
        String fileName = ResourceHelper.getAbsoluteFilePath("app.log");
        
        byte[] bytes = Files.readAllBytes(Paths.get(fileName));
        String content = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(content);
        
    }
}
