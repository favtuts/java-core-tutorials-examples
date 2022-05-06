package com.favtuts.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileParallel {

    public static void main(String[] args) throws IOException {
        
        //String fileName = ResourceHelper.getAbsoluteFilePath("app.log");
        String fileName = "/home/tvt/workspace/favtuts/large.txt";

        // auto-close the resoures
        Stream<String> lines = Files.lines(Paths.get(fileName));

        lines.parallel().forEach(l -> { 
            System.out.println(l);
        });
    }
}
