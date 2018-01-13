package chapter04;

import chapter02.singleton.DoubleLockSingleton;

import java.util.Arrays;
import java.util.Collections;
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
}
