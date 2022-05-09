package com.favtuts.io.howto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class InputStreamToFile {

    /**
     * The default buffer size
     */
    public static final int DEFAULT_BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        
        URI u = URI.create("https://www.google.com/");
        try (InputStream inputStream = u.toURL().openStream()) {
            
            File file = new File("/home/tvt/workspace/favtuts/google.txt");
            copyInputStreamToFile(inputStream, file);

        }
    }
    
    private static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {

        // append = false
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {

            int read;
            byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];

            while((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
    }

}
