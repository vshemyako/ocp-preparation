package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Reviewing helper methods of a {@link java.nio.file.Files} class
 */
public class FilesHelperClass {

    /**
     * Prints filename if it exists
     */
    private static void printIfExists() {
        Path realPath = Paths.get("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\nio\\RealFile.txt");
        if (Files.exists(realPath)) {
            System.out.println(realPath.getFileName());
        }

        Path fakePath = Paths.get("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\nio\\FakeFile.lnk");
        if (Files.exists(fakePath, LinkOption.NOFOLLOW_LINKS)) {
            System.out.println(fakePath.getFileName());
        }

        Path fakeFolderPath = Paths.get("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\nio\\FakeFolder\\RealFile.txt");
        if (Files.exists(fakeFolderPath)) {
            System.out.println(fakeFolderPath.getFileName());
        } else {
            System.out.println("Doesn't exist");
        }
    }

    /**
     * Utilizes isSameFile method
     */
    private static void isTheSame() throws IOException {
        Path realPath = Paths.get("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\nio\\RealFile.txt");
        Path fakePath = Paths.get("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\nio\\FakeFile.lnk");

        System.out.println(Files.isSameFile(realPath, fakePath));
    }

    /**
     * Application entry point
     */
    public static void main(String[] args) throws IOException {
        printIfExists();
        isTheSame();
    }
}
