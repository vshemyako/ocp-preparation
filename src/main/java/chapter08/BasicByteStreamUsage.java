package chapter08;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Playing around with some byte stream methods
 */
public class BasicByteStreamUsage {

    /**
     * Shows how to use {@link java.io.InputStream#mark(int)} method
     */
    private static void markPosition() {
        File textFile = new File("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\chapter08\\abc.txt");
        if (textFile.exists()) {
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(textFile));) {
                //have to check if our input stream instance support desired method
                if (inputStream.markSupported()) {
                    int readLimit = 10;
                    //define bytes read limit
                    inputStream.mark(readLimit);
                    //just converts to a symbol
                    for (int index = 0; index < readLimit; index++) {
                        System.out.print((char) inputStream.read() + " ");
                    }
                    inputStream.reset();
                    System.out.print((char) inputStream.read() + " ");

                }
            } catch (IOException e) {
                //handle some way
            }
        }
    }

    /**
     * Sometimes you need to skip several bytes in order not to output them
     */
    private static void skipBytes() {
        File textFile = new File("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\chapter08\\abc.txt");
        //lets print the first and the last letters from ABC
        try (FileInputStream inputStream = new FileInputStream(textFile);) {
            System.out.println((char) inputStream.read()); //A
            long bytesToSkip = 24;
            long actualNumber = inputStream.skip(bytesToSkip);
            System.out.println((char) inputStream.read()); //Z
            System.out.println("Number of bytes skipped: " + actualNumber);
        } catch (IOException e) {
            //handle to rethrow
        }
    }

    /**
     * Entry point
     */
    public static void main(String[] args) {
        //markPosition();
        skipBytes();
    }
}