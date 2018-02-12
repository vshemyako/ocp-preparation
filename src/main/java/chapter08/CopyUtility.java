package chapter08;

import java.io.*;

/**
 * Shows how to copy a file using low-level byte stream
 */
public class CopyUtility {

    /**
     * Inefficient approach which doesn't use buffer.
     * Note: even if to file doesn't exist on the file system it will be create; otherwise - rewritten
     */
    private static void copy(File from, File to) {
        try (FileInputStream inputStream = new FileInputStream(from);
             FileOutputStream outputStream = new FileOutputStream(to)) {
            int byteRead;
            while ((byteRead = inputStream.read()) != -1) {
                outputStream.write(byteRead);
            }
        } catch (IOException e) {
            //handle exception
        }
    }

    /**
     * More efficient approach which uses buffer.
     * Note: even if to file doesn't exist on the file system it will be create; otherwise - rewritten
     */
    private static void copyWithBuffer(File from, File to) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(from));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(to))) {
            //it's good idea to use buffer with power of 2 size
            byte[] buffer = new byte[32];
            int remainder;
            while ((remainder = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, remainder);
            }
        } catch (IOException e) {
            //handle exception
        }
    }

    /**
     * Entry point
     */
    public static void main(String[] args) {
        File from = new File("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\chapter08\\abc.txt");
        File to = new File("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\chapter08\\abc_copied.txt");
        copyWithBuffer(from, to);
    }
}
