package chapter09;

import java.io.Console;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * It's possible to determine whether a path is absolute or relative. Pay attention: this info is file system dependent
 */
public class AbsoluteAndRelativePaths {

    /**
     * Different {@link Path} interface methods
     */
    public static void main(String[] args) {
        Path path = Paths.get("c:/folder/folder/folder");
        System.out.println(path.isAbsolute());
        System.out.println(path.toAbsolutePath());

        path = Paths.get("folder/folder/folder");
        System.out.println(path.isAbsolute());
        System.out.println(path.toAbsolutePath());

        //Pay special attention to this one, cuz it's not so obvious
        //Note: #relativize method doesn't allow mixing relative and absolute paths
        Path relativePath1 = Paths.get("text.txt");
        Path relativePath2 = Paths.get("document.doc");
        System.out.println(relativePath1.relativize(relativePath2));

        Path absolutePath1 = Paths.get("C:\\folder1\\text.txt");
        Path absolutePath2 = Paths.get("C:\\folder2\\text.txt");
        System.out.println(absolutePath1.relativize(absolutePath2));

        //Resolve instead of relativize
        //Note: #resolve actually allows mixing of different path types
        Path absolutePath3 = Paths.get("/one/../two");
        Path absolutePath4 = Paths.get("three");
        System.out.println(absolutePath3.resolve(absolutePath4));
        System.out.println(absolutePath4.resolve(absolutePath3));

        //Combining relativize/resolve methods can end up with redundancies in a file path
        //#normalize method is invented for those issues
        System.out.println("Normalized: " + Paths.get("C:\\one\\..\\two\\three").normalize());
    }
}
