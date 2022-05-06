package com.favtuts.io.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.favtuts.io.utils.ResourceHelper;

public class ReadFile4 {
    
    public static void main(String[] args) throws IOException {

        String fileName = ResourceHelper.getAbsoluteFilePath("app.log");
        
        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        lines.forEach(System.out::println);
    }
}
