package enthuware;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Review usages of collect terminal operation
 */
public class ConvertingStreamToCollection {

    private static void predefinedCollections() {
        //Generate stream of numbers;
        Stream<Integer> numbers = IntStream.rangeClosed(0, 10).boxed();

        //As one may see -> it's rather simple
        //What is peculiar here -> concrete collection implementation isn't defined
        Collector<Integer, ?, List<Integer>> numbersListCollector = Collectors.toList();
        Collector<Integer, ?, Set<Integer>> numbersSetCollector = Collectors.toSet();

        //Converting is easy
        List<Integer> numbersList = numbers.collect(numbersListCollector);
        Set<Integer> numbersSet = numbers.collect(numbersSetCollector);

        //Let's specify our own collection type
        Collector<Integer, ?, LinkedList<Integer>> numbersLinkedListCollector = Collectors.toCollection(LinkedList::new);
        Collector<Integer, ?, TreeSet<Integer>> numbersTreeSetCollector = Collectors.toCollection(TreeSet::new);

        //Converting the same way
        LinkedList<Integer> numbersLinkedList = numbers.collect(numbersLinkedListCollector);
        TreeSet<Integer> numbersTreeSet = numbers.collect(numbersTreeSetCollector);
    }

    //As always map is a bit different from the whole Collection framework
    //There're three different approaches how to create a Map Collector
    private static void collectToMap() {
        //let's generate letters from ABC
        Stream<String> letters = Stream
                .iterate('a', (Character t) -> (char) (t + 1))
                .limit(10)
                .map(String::valueOf);

        //First, the most easiest approach
        //We have a stream of same element, so we have to specify, how to convert those elements to Key and Value!
        Collector<String, ?, Map<String, Integer>> mapCollector = Collectors.toMap(Function.identity(), String::length);
        Map<String, Integer> letterToLength = letters.collect(mapCollector);

        //If we encounter the same key in a stream -> exception is thrown, but there's a workaround
        BinaryOperator<Integer> collisionResolver = (firstValue, secondValue) -> firstValue + secondValue;
        //Map collector with resolver
        Collector<String, ?, Map<String, Integer>> collectorWithResolver =
                Collectors.toMap(Function.identity(), String::length, collisionResolver);
        Map<String, Integer> nothingToBeAfraidAbout = letters.collect(collectorWithResolver);

        //Define Map type
        Collector<String, ?, TreeMap<String, Integer>> treeMapCollector =
                Collectors.toMap(Function.identity(), String::length, collisionResolver, TreeMap::new);
        TreeMap<String, Integer> customMap = letters.collect(treeMapCollector);
    }

    //Very easy to sum elements, just convert them to int, double or long
    private static void sumElements() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5);
        ToIntFunction<Integer> convertToInt = number -> number;
        ToDoubleFunction<Integer> convertToDouble = number -> number * 2;
        ToLongFunction<Integer> convertToLong = number -> number * 5;

        Collector<Integer, ?, Integer> intSumCollector = Collectors.summingInt(convertToInt);
        Integer intSum = numbers.stream().collect(intSumCollector);

        Collector<Integer, ?, Double> doubleSumCollector = Collectors.summingDouble(convertToDouble);
        Double doubleSum = numbers.stream().collect(doubleSumCollector);

        Collector<Integer, ?, Long> longSumCollector = Collectors.summingLong(convertToLong);
        Long longSum = numbers.stream().collect(longSumCollector);

        System.out.println(intSum);
        System.out.println(doubleSum);
        System.out.println(longSum);
    }

    //It's possible to split element by key
    private static void groupElements() {
        Stream<String> words = Stream.of("one", "two", "three", "four", "five");
        Function<String, Integer> conversion = String::length;
        Collector<String, ?, Map<Integer, List<String>>> mapCollector = Collectors.groupingBy(conversion);
        //Map<Integer, List<String>> lengthToWords = words.collect(mapCollector);

        Collector<String, ?, Map<Integer, String>> collector = Collectors.groupingBy(conversion, Collectors.joining());
        Map<Integer, String> lengthToJoinWords = words.collect(collector);
        System.out.println(lengthToJoinWords);
    }

    /**
     * Fires up collectors
     */
    public static void main(String[] args) {
        //collectToMap();
        //sumElements();
        groupElements();
    }
}
