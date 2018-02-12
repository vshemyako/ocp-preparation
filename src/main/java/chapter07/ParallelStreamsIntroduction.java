package chapter07;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Shows the ways of creating a parallel stream
 */
public class ParallelStreamsIntroduction {

    /**
     * Creates a parallel stream from a serial
     */
    private static void fromSerialToParallel() {
        Stream<String> words = Stream.of("one", "two", "three", "four", "five");
        Stream<String> parallelWords = words.parallel();

        //elements aren't output in the order they were added
        parallelWords.forEach(System.out::println);
    }

    /**
     * Creates a parallel stream from a collection
     */
    private static void fromCollectionToParallel() {
        Collection<Number> numbers = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        Stream<Number> parallelNumbers = numbers.parallelStream();

        //once again, elements aren't output sequentially
        parallelNumbers.forEach(System.out::println);
    }

    /**
     * Orders elements processing
     */
    private static void useOrderedProcessing() {
        Collection<Object> objects = Arrays.asList(11, 22, 33, 44, 55);
        //enforce ordered processing
        objects.parallelStream().forEachOrdered(System.out::println);
    }

    /**
     * As always - simple entry point
     */
    public static void main(String[] args) {
        //fromSerialToParallel();
        //fromCollectionToParallel();
        useOrderedProcessing();
    }
}
