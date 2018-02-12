package chapter09;

import java.io.Console;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 10.000 feet examination of {@link java.nio.file.Path} interface methods
 */
public class PathMethods {

    /**
     * Main method =)
     */
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\chapter08\\abc_copied.txt");

        //Basic path info
        Console console = System.console();
        PrintWriter writer = console.writer();
        writer.println("Path is:");
        writer.println(path.toString());

        //Iterating over a path object
        //Pay attention that root element is not included
        path.forEach(writer::println);

        //It's possible to achieve the same result in more complex way
        writer.println("More complex way:");
        for(int index = 0; index < path.getNameCount(); index++) {
            writer.println(path.getName(index));
        }
    }
}
