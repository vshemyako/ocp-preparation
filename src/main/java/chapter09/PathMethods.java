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
    public static void custom() {
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

    private static void pathParent() {
        Path path = Paths.get("asd/as/b");
        Path path2 = Paths.get("/asd/asda/c");

        System.out.println("Parent");
        System.out.println(path.getParent());
        System.out.println("Root");
        System.out.println(path.getRoot());

        System.out.println("Resolve sibling:");
        System.out.println(path.resolveSibling(path2));
        Path parent = path.getParent();
        System.out.println(parent.resolve(path2));
    }

    public static void main(String[] args) {
        pathParent();
    }
}
