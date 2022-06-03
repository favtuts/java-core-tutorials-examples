package com.favtuts.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamNeedToClose {
    
    public static void main(String[] args) {
        //demoStreamNoNeedToClose();
        demoStreamIONeedToClose();
    }

    static void demoStreamIONeedToClose() {
        String path = "/home/tvt/workspace/favtuts/lines.txt";

		// auto close
        try (Stream<String> lines = Files.lines(Paths.get(path))) {

            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            System.out.println(content);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void demoStreamNoNeedToClose() {
        Stream<String> stream = Stream.of("A", "B", "C");

        List<String> filter = stream.filter(x -> !x.equalsIgnoreCase("B"))
			.collect(Collectors.toList());

        // no need close the stream.
        //stream.close();

        System.out.println(filter); // [A, C]
    }
}
