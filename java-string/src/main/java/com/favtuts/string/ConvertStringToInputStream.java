package com.favtuts.string;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class ConvertStringToInputStream {

    public static final int DEFAULT_BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {

        String name = "favtuts.com";

        // String to InputStream
        InputStream is = new ByteArrayInputStream(name.getBytes(StandardCharsets.UTF_8));

        // current directory        
        Path cwd = Path.of("").toAbsolutePath();            
        String filePath = cwd.toString() + "/file.txt";

        // save to a file
        save(is, filePath);

    }

    // save the InputStream to a File
    private static void save(final InputStream is, final String fileName)
        throws IOException {

        // read bytes from InputStream and write it to FileOutputStream
        try (FileOutputStream outputStream =
                     new FileOutputStream(new File(fileName), false)) {
            int read;
            byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
            while ((read = is.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }
    }
    
}
