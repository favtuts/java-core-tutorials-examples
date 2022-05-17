package com.favtuts.io.howto;

public class GetFileExtension {

    private static final String OUTPUT_FORMAT = "Path: %-30s -> File Extension: %s";
    private static final String WINDOWS_FILE_SEPARATOR = "\\";
    private static final String UNIX_FILE_SEPARATOR = "/";
    private static final String FILE_EXTENSION = ".";

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
            //String output = String.format(OUTPUT_FORMAT, file, getFileExtension(file));
            String output = String.format(OUTPUT_FORMAT, file, getFileExtensionImproved(file));
            System.out.println(output);
        }
    }

    /**
     * Add extra checking for below cases
     * <p>
     * "/path/../makefile",
     * "/path/dir.test/makefile"
     */
    public static String getFileExtensionImproved(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("fileName must not be null!");
        }

        String extension = "";

        int indexOfLastExtension = fileName.lastIndexOf(FILE_EXTENSION);

        // check last file separator, windows and unix
        int lastSeparatorPosWindows = fileName.lastIndexOf(WINDOWS_FILE_SEPARATOR);
        int lastSeparatorPosUnix = fileName.lastIndexOf(UNIX_FILE_SEPARATOR);

        // takes the greater of the two values, which mean last file separator
        int indexOflastSeparator = Math.max(lastSeparatorPosWindows, lastSeparatorPosUnix);

        // make sure the file extension appear after the last file separator
        if (indexOfLastExtension > indexOflastSeparator) {
            extension = fileName.substring(indexOfLastExtension + 1);
        }

        return extension;
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
