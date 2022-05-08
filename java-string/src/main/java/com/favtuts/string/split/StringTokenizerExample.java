package com.favtuts.string.split;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringTokenizerExample {

    public static void main(String[] args) throws IOException {
        /*
        StringTokenizer st = new StringTokenizer("1, 2, 3, 4, 5");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken().trim());
        }
        */
        
        /*        
        String line = "This is a String, split by, StringTokenizer example.";
        List<String> result = split(line, ",");
        for (String s : result) {
            System.out.println(s.trim());
        }
        */

        StringTokenizerExample obj = new StringTokenizerExample();
        //List<Trend> trends = obj.readFromResource("sample.csv", "|");
        List<Trend> trends = obj.readFile(Paths.get("/home/tvt/workspace/favtuts/sample.csv"), "|");
        trends.forEach(System.out::println);
    }
    
    public static List<String> split(String line, String delimiter) {
        List<String> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line, delimiter);
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        return result;
    }


    // get a file from resources folder
    // works in everywhere, IDEA, unit test and JAR file.
    public InputStream getFileFromResourceAsStream(String fileName) {

        // for static access
        //ClassLoader classLoader1 = FileResourcesUtils.class.getClassLoader();

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    public List<Trend> readFile(Path path, String delimiter) throws IOException {
        List<Trend> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {

            String line;
            while((line = br.readLine()) != null) {
                Trend td = parseStringLine(line, delimiter);
                if (td != null)
                    result.add(td);
            }
        }

        return result;
    }

    public List<Trend> readFromResource(String fileName, String delimiter) throws IOException {

        List<Trend> result = new ArrayList<>();
        InputStream is = getFileFromResourceAsStream(fileName);
        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                Trend td = parseStringLine(line, delimiter);
                if (td != null)
                    result.add(td);
            }

        }

        return result;
    }

    private Trend parseStringLine(String line, String delimiter) {
        StringTokenizer st = new StringTokenizer(line, delimiter);
        Trend result = null;
        while(st.hasMoreTokens()) {
            Integer id = Integer.parseInt(st.nextToken().trim());
            Double index = Double.parseDouble(st.nextToken().trim());
            String desc = st.nextToken().trim();
            result = new Trend(id, index, desc);
        }
        return result;
    }

    class Trend {
        private int id;
        private Double index;
        private String desc;

        public Trend(int id, Double index, String desc) {
            this.id = id;
            this.index = index;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "Trend{" +
                    "id=" + id +
                    ", index=" + index +
                    ", desc='" + desc + '\'' +
                    '}'; 
        }
    }
}
