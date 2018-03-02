package io;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Reviewing some tricky parts of java.io package
 */
public class RevisionOfIO {

    /**
     * Demonstrates different possibilities to create {@link java.io.File} object
     */
    private static void construct() {
        File firstConstructor = new File("first");
        File secondConstructor = new File("parent", "child");
        File thirdConstructor = new File(secondConstructor, "another child");
        try {
            File forthConstructor = new File(new URI("URI"));
        } catch (URISyntaxException e) {
            //handle exception
        }
    }

    /**
     * Method returns absolute file paths not a bottle of vodka
     */
    private static void getAbsolute() {
        File file = new File("");
        //returns current user directory if specified path is empty
        System.out.println(file.getAbsolutePath());
    }

    /**
     * Tests whether a file is a directory or file
     */
    private static void directoryOfFile() {
        File file = new File("file.file");
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Is file: " + file.isFile());
    }

    /**
     * Returns file size
     */
    private static void size() {
        File file = new File("");
        System.out.println(file.length());
    }

    /**
     * Edge case with normalize
     */
    private static void normalize() {
        Path path = Paths.get(".");
        System.out.println(path);
        System.out.println(path.normalize());
        System.out.println(path.getNameCount());
    }

    private static void parent() {
        Path path = Paths.get("/sang");
        System.out.println(path);
        path = path.getParent();
        System.out.println(path);
        path = path.getRoot();
        System.out.println(path);
    }

    /**
     * Works like a horse
     */
    public static void main(String[] args) {
        //getAbsolute();
        //directoryOfFile();
        //size();
        //normalize();
        parent();
    }
}