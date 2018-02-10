package chapter09;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * {@link java.nio.file.Path} interface is the main entry point to NIO.2.
 * To obtain an instance of this interface - Paths factory class is used.
 */
public class PathConstructors {

    /**
     * Demonstrates different possibilities to construct {@link java.nio.file.Path} objects
     */
    public static void main(String[] args) {
        Path firstPath = Paths.get("c:/first/second/third");
        Path secondPath = Paths.get("c:", "first", "second", "third");

        try {
            URI uriPath = new URI("file:///c:/first/second/third");
            Path thirdPath = Paths.get(uriPath);
        } catch (URISyntaxException e) {
            //uri syntax exception
        }

        //legacy code support
        File firstFile = firstPath.toFile();
        firstPath = firstFile.toPath();
    }
}
