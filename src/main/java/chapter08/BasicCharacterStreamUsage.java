package chapter08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Shows how to use buffered character streams to copy a file
 */
public class BasicCharacterStreamUsage {

    /**
     * Reads a file into memory (list of {@link String} objects)
     */
    private static List<String> readAFile(File source) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String tempLine;
            //new line character is a line termination
            while ((tempLine = reader.readLine()) != null) {
                words.add(tempLine);
            }
        } catch (IOException e) {
            //handle exception
        }
        return words;
    }

    private static void writeAFile(List<String> inMemoryBuffer, File destination) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String letter : inMemoryBuffer) {
                writer.write(letter);
            }
        } catch (IOException e) {
            //handle exception
        }
    }

    /**
     * Entry point
     */
    public static void main(String[] args) {
        File abcFile = new File("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\chapter08\\newlinesabc.txt");
        File destFile = new File("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\chapter08\\abcinoneline.txt");
        List<String> alphabet = readAFile(abcFile);
        /*
        for (String letter : alphabet) {
            System.out.println(letter);
        }
        */
        writeAFile(alphabet, destFile);
    }
}
