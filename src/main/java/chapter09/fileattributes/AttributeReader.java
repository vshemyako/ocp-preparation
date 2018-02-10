package chapter09.fileattributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * With NIO.2 its also possible to read attributes of a file or a directory, even system-specific
 */
public class AttributeReader {

    /**
     * Note: those methods don't throw exception if a file or directory does not exist
     */
    private static void readRegularAttributes() {
        Path directory = Paths.get("c:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\resources\\directory");
        Path regularFile = Paths.get("c:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\resources\\file");
        Path symbolicLinkToFile = Paths.get("c:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\resources\\symboliclink.lnk");
        Path hiddenFile = Paths.get("c:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\resources\\hiddenfile");

        //directories part
        System.out.println("Is directory: " + Files.isDirectory(directory));
        System.out.println("Is directory: " + Files.isDirectory(regularFile));
        //will return true if a symbolic link points to a directory
        System.out.println("Is directory: " + Files.isDirectory(symbolicLinkToFile));

        //files part
        System.out.println("Is file: " + Files.isRegularFile(directory));
        System.out.println("Is file: " + Files.isRegularFile(regularFile));
        //will return true if a symbolic link points to a file
        System.out.println("Is file: " + Files.isRegularFile(symbolicLinkToFile));

        //symbolic links
        System.out.println("Is symbolic: " + Files.isSymbolicLink(symbolicLinkToFile));

        try {
            System.out.println("Is file hidden: " + Files.isHidden(regularFile));
            System.out.println("Is file hidden: " + Files.isHidden(hiddenFile));
        } catch (IOException e) {
            //handle IO exception
        }
    }

    /**
     * Application's entry point
     */
    public static void main(String[] args) {
        readRegularAttributes();
    }
}
