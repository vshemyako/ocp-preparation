package chapter04;

import chapter02.singleton.DoubleLockSingleton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Powerful notion of streams was introduced in JDK 1.8 which is similarly to assembly line. This is the key topic for
 * the OCP exam
 */
public class LearningStreams {

    /**
     * Lists the ways to create finite streams
     */
    public static void createFiniteStream() {
        //Create empty stream
        Stream<Integer> emptyStream = Stream.empty();

        //Create stream of one element
        Stream<Integer> oneElementStream = Stream.of(1);

        //Create stream of finite number of elements
        Stream<Integer> finiteElementsStream = Stream.of(1, 2, 3);

        //Create stream from an array, uses varargs method signature
        Stream<Integer> arrayStream = Stream.of(new Integer[]{4, 5, 6});

        //Create stream from a collection
        Stream<Integer> collectionStream = Arrays.asList(7, 8, 9, 10).stream();

        //Create parallel stream from a collection, useful for big chunks of data
        Stream<Integer> parallelCollectionStream = Collections.EMPTY_LIST.parallelStream();
    }

    /**
     * Lists basic ways of infinite stream creation
     */
    public static void createInfiniteStream() {
        //Create infinite stream of random values
        Stream<Double> infiniteRandomNumbersStream = Stream.generate(Math::random);

        //Create infinite stream from initial seed (value)
        Stream<String> infiniteStringsStream = Stream.iterate("odd", word -> word.length() % 2 == 0 ? "odd" : "even");
    }

    /**
     * Terminal stream operations are final in assembly line
     */
    public static void examineTerminalOperationsUponStreams() {
        List<Integer> numbers = Arrays.asList(20, 3, 40, 1, -2);

        //Count operation - determines the number of elements in a stream, obviously hangs on infinite stream
        //It's a reduction operation
        long numberOfElements = numbers.stream().count();
        System.out.println("Stream size is: " + numberOfElements);

        //Retrieves the smallest value from a stream
        //It's a reduction operation
        Optional<Integer> minimalOptional = numbers.stream().min(Integer::compare);
        System.out.println("The minimal value is: " + minimalOptional.orElse(null));

        //Retrieves the largest value from a stream
        //It's a reduction operation
        Optional<Integer> maximumOptional = numbers.stream().max(Integer::compare);
        System.out.println("The maximum value is: " + maximumOptional.orElse(null));

        //Retrieves first element of a stream
        //For parallel stream findAny is preferable but is not deterministic
        Optional<Integer> firstStreamElement = numbers.stream().findFirst();
        Optional<Integer> firstAnyStreamElement = numbers.stream().findAny();
        System.out.println("The first stream element: " + firstStreamElement.orElse(null));
        System.out.println("The first any stream element: " + firstAnyStreamElement.orElse(null));

        //anyMatch, allMatch, noneMatch methods test stream elements upon predicate
        //Some infinite streams could obviously not terminate
        Predicate<Integer> equalsPredicate = number -> new Integer(1).equals(number);
        Predicate<Integer> forNoneMatchPredicate = number -> number > 1000;
        Predicate<Integer> forAllMatchPredicate = number -> number > -1000;
        System.out.println(numbers.stream().anyMatch(equalsPredicate));
        System.out.println(numbers.stream().noneMatch(forNoneMatchPredicate));
        System.out.println(numbers.stream().allMatch(forAllMatchPredicate));

        //Easy way to print all elements of a stream, accept Consumer
        System.out.println("Print all stream elements:");
        numbers.stream().forEach(System.out::println);
    }

    /**
     * Tests desired method
     */
    public static void main(String[] args) {
        examineTerminalOperationsUponStreams();
    }
}
