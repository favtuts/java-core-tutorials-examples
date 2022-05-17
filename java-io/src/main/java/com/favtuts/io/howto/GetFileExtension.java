package com.favtuts.io.howto;

public class GetFileExtension {

    private static final String OUTPUT_FORMAT = "Path: %-30s -> File Extension: %s";

    public static void main(String[] args) {
        
        String[] files = {
            "/path/foo.txt",
            ".",
            "..",
            "/path/run.exe",
            "/path/makefile",
            "/path/.htaccess",
            "/path/.tar.gz",
            "/path/../makefile",
            "/path/dir.test/makefile"
        };

        for (String file : files) {
            String output = String.format(OUTPUT_FORMAT, file, getFileExtension(file));
            System.out.println(output);
        }
    }


    /**
     * Fail for below cases
     * <p>
     * "/path/../makefile",
     * "/path/dir.test/makefile"
     */
    public static String getFileExtension(String fileName) {

        if (fileName == null) {
            throw new IllegalArgumentException("fileName must not be null!");
        }

        String extension = "";
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            extension = fileName.substring(index + 1);
        }

        return extension;
    }
    
}
