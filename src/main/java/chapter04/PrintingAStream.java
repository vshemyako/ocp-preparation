package chapter04;

import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * There are number of way to print stream's elements. Some of the are destructive some are not. This class examines all
 * possibilities.
 */
public class PrintingAStream {

    /**
     * Printing a stream using {@link Stream#forEach(Consumer)} is destructive to the stream
     */
    public static void printUsingEach() {
        Stream<Integer> streamOfNumbers = Stream.of(10, 20, 30, 40, 50);
        streamOfNumbers.forEach(System.out::println);

        //will not work
        try {
            streamOfNumbers.forEach(System.out::println);
        } catch (IllegalStateException ex) {
            System.out.println("The stream was destructed");
        }
    }

    /**
     * It's possible to collect stream elements with a collection and print it.
     * But again this approach is also destructive
     */
    public static void printUsingCollect() {
        Stream<Integer> streamOfNumbers = Stream.of(10, 20, 30, 40, 50);
        System.out.println(streamOfNumbers.collect(Collectors.toList()));

        //will not work
        try {
            streamOfNumbers.forEach(System.out::println);
        } catch (IllegalStateException ex) {
            System.out.println("The stream was destructed");
        }
    }

    /**
     * The only approach that doesn't destroy the stream is using {@link Stream#peek(Consumer)}
     */
    public static void printUsingPeek() {
        Stream<Integer> streamOfNumbers = Stream.of(10, 20, 30, 40, 50);
        //Adding terminal operation -> without it the assembly line isn't ready
        streamOfNumbers.peek(System.out::println).count();

        //showing that this approach isn't destructive
        Stream<String> streamOfWords = Stream.of("one", "two", "three");
        streamOfWords.peek(System.out::print).peek(System.out::print).count();
    }

    /**
     * Fires up desired method
     */
    public static void main(String[] args) {
        printUsingEach();
        printUsingCollect();
        printUsingPeek();
    }
}
