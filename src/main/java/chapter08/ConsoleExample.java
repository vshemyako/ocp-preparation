package chapter08;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileWriter;
import java.io.Writer;

/**
 * JDK1.6 introduced {@link java.io.Console} class to use in text-based environments
 */
public class ConsoleExample {

    public static void main(String[] args) {
        Console console = System.console();
        //folks say that sometimes text interaction is forbidden
        if (console != null) {
            String usersInput = console.readLine();
            console.writer().println(usersInput);
        }
    }
}
