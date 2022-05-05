package com.favtuts.string;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class ConvertBytesToStringBase64 {

    public static void main(String[] args) {
        String filePath = ClassLoader.getSystemResource("phone.png").getFile();
        Path path = Paths.get(filePath);

        if (Files.notExists(path)) {
            throw new IllegalArgumentException("File is not exists!");
        }

        try {
            // convert the file's content to byte[]
            byte[] bytes = Files.readAllBytes(path);

            // encode, byte[] to Base64 encoded string
            String s = Base64.getEncoder().encodeToString(bytes);
            System.out.println(s);

            // decode, Base64 encoded string to byte[]
            byte[] decode = Base64.getDecoder().decode(s);

            // save into another image file
            // current directory            
            Path cwd = Path.of("").toAbsolutePath();            
            System.out.println(cwd.toString());

            Files.write(Paths.get(cwd.toString() + "/phone2.png"), decode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
