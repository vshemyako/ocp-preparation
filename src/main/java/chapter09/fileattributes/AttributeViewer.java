package chapter09.fileattributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Another approach to work with attributes of files or directories
 */
public class AttributeViewer {

    /**
     * Shows basic usage of {@link BasicFileAttributes} instance
     */
    private static void viewAttributes() throws IOException {
        Path file = Paths.get("c:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\resources\\file");
        BasicFileAttributes attributeView = Files.readAttributes(file, BasicFileAttributes.class);
        System.out.println("Is directory: " + attributeView.isDirectory());
        System.out.println("Is file: " + attributeView.isRegularFile());
        System.out.println("Is symbolic: " + attributeView.isSymbolicLink());
        //etc.
    }
}
