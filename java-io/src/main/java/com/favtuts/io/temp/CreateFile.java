package com.favtuts.io.temp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.EnumSet;
import java.util.Set;

public class CreateFile {

    public static void main(String[] args) {

        try {
            /*
            Path path = Paths.get("/home/tvt/workspace/favtuts/temp/test1.log");

            Set<PosixFilePermission> perms = EnumSet.of(
                    PosixFilePermission.OWNER_READ,
                    PosixFilePermission.OWNER_WRITE,
                    PosixFilePermission.OWNER_EXECUTE,
                    PosixFilePermission.GROUP_READ,
                    PosixFilePermission.GROUP_WRITE,
                    PosixFilePermission.GROUP_EXECUTE,
                    PosixFilePermission.OTHERS_READ,
                    PosixFilePermission.OTHERS_WRITE,
                    PosixFilePermission.OTHERS_EXECUTE);

            Files.createFile(path, PosixFilePermissions.asFileAttribute(perms));
            */

            Path path = Paths.get("/home/tvt/workspace/favtuts/temp/test2.log");

            Set<PosixFilePermission> perms =
                    PosixFilePermissions.fromString("rwxrwxrwx");

            Files.createFile(path, PosixFilePermissions.asFileAttribute(perms));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
