package com.favtuts.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.favtuts.io.utils.ResourceHelper;

public class ReadFile1 {

    public static void main(String[] args) throws IOException {
        
        String fileName = ResourceHelper.getAbsoluteFilePath("app.log");

        // auto-close the resoures
        Stream<String> lines = Files.lines(Paths.get(fileName));

        // does not preserve order
        lines.forEach(System.out::println);

        // preserve order
        // lines.forEachOrdered(System.out::println);
    }

}
