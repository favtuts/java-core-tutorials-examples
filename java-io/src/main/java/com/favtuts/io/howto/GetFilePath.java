package com.favtuts.io.howto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFilePath {
    
    public static void main(String[] args) {

        // full path
        Path path1 = Paths.get("/home/tvt/workspace/favtuts/test/file.txt");
        System.out.println("\n[Path] : " + path1);
        printPath(path1);

        // file name
        Path path2 = Paths.get("file.txt");
        System.out.println("\n[Path] : " + path2);
        printPath(path2);

        // soft or symbolic link
        Path path3 = Paths.get("/home/tvt/workspace/favtuts/test/soft-link");
        System.out.println("\n[Path] : " + path3);
        printPath(path3);

        // a path contains `..`
        Path path4 = Paths.get("/home/tvt/workspace/favtuts/test/../hello.txt");
        System.out.println("\n[Path] : " + path4);
        printPath(path4);
        
    }

    static void printPath(Path path) {

        System.out.printf("%-25s : %s%n", "path", path);
        System.out.printf("%-25s : %s%n", "path.toAbsolutePath()",
                                                path.toAbsolutePath());
        System.out.printf("%-25s : %s%n", "path.getParent()", path.getParent());
        System.out.printf("%-25s : %s%n", "path.getRoot()", path.getRoot());

        try {

            if (Files.notExists(path)) {
                return;
            }

            // default, follow symbolic link
            System.out.printf("%-25s : %s%n", "path.toRealPath()",
                                                  path.toRealPath());
            // no follow symbolic link
            System.out.printf("%-25s : %s%n", "path.toRealPath(nofollow)",
                path.toRealPath(LinkOption.NOFOLLOW_LINKS));

            // alternative to check isSymbolicLink
            /*if (Files.isSymbolicLink(path)) {
                Path link = Files.readSymbolicLink(path);
                System.out.println(link);
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
