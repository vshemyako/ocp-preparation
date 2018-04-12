package chapter04;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * It turned out that OCP requires good knowledge of reduction operations
 */
public class CollectOperationUponStream {

    //applies only to CharSequence streams
    private static void joinElements() {
        List<String> letters = Arrays.asList("a", "b", "c");
        //without delimiter
        System.out.println(letters.stream().collect(Collectors.joining()));

        //with delimiter
        System.out.println(letters.stream().collect(Collectors.joining(", ")));

        //with delimiter, prefix and suffix
        System.out.println(letters.stream().collect(Collectors.joining(", ", "Start: \n", "\nEnd.")));
    }

    //counts elements of a Stream
    private static void countElements() {
        List<String> letters = Arrays.asList("a", "b", "c");
        System.out.println(letters.stream().count());

        //using Collector -> extra verbose actually
        System.out.println(letters.stream().collect(Collectors.counting()));
    }

    //counts average
    private static void average() {

        //just for testing purposes
        class Box {
            private int intNumber;
            private long longNumber;
            private double doubleNumber;

            public Box(int intNumber, long longNumber, double doubleNumber) {
                this.intNumber = intNumber;
                this.longNumber = longNumber;
                this.doubleNumber = doubleNumber;
            }

            public int getIntNumber() {
                return intNumber;
            }

            public void setIntNumber(int intNumber) {
                this.intNumber = intNumber;
            }

            public long getLongNumber() {
                return longNumber;
            }

            public void setLongNumber(long longNumber) {
                this.longNumber = longNumber;
            }

            public double getDoubleNumber() {
                return doubleNumber;
            }

            public void setDoubleNumber(double doubleNumber) {
                this.doubleNumber = doubleNumber;
            }
        }

        List<Box> boxes = Arrays.asList(
                new Box(10, 10L, 10.0),
                new Box(20, 20L, 20.0),
                new Box(15, 15L, 15.0)
        );

        List<Box> collect = boxes
                .stream()
                .collect(Collectors.toList());

        List<Box> noBoxes = Collections.emptyList();

        //all averaging functions return double
        System.out.println(noBoxes.stream().collect(Collectors.averagingInt(Box::getIntNumber)));
        System.out.println(boxes.stream().collect(Collectors.averagingLong(Box::getLongNumber)));
        System.out.println(boxes.stream().collect(Collectors.averagingDouble(Box::getDoubleNumber)));
    }

    //finds min/max element of a stream
    private static void minMaxElement() {
        List<String> letters = Arrays.asList("a", "b", "c");

        Optional<String> minElement = letters.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println(minElement.orElse(""));

        Optional<String> maxElement = letters.stream().collect(Collectors.minBy(Comparator.reverseOrder()));
        System.out.println(maxElement.orElse(""));
    }

    //collecting into maps
    private static void collectToMap() {
        List<String> letters = Arrays.asList("a", "b", "c");
        Map<String, Integer> firstMap = letters
                .stream()
                .collect(Collectors.toMap(letter -> letter, String::length));

        //remember if we would encounter the same keys -> Collector will throw an exception;
        try {
            Map<Integer, String> secondMap = letters
                    .stream()
                    .collect(Collectors.toMap(String::length, letter -> letter));
        } catch (IllegalStateException e) {
            System.out.println("God damn duplicate key");
        }

        //we can merge values for the same keys
        Map<Integer, String> thirdMap = letters
                .stream()
                .collect(Collectors.toMap(String::length, letter -> letter, (one, two) -> one));
        System.out.println(thirdMap);

        //it's also possible to specify type of generated map
        TreeMap<Integer, String> forthMap = letters
                .stream()
                .collect(Collectors.toMap(String::length, letter -> letter, (one, two) -> one, TreeMap::new));
        System.out.println(forthMap);
    }

    //group elements
    private static void groupElements() {
        List<String> letters = Arrays.asList("a", "ba", "ca", "d", "ea", "f");

        //specify a function result of which is a key
        Map<Integer, List<String>> firstMap = letters
                .stream()
                //.filter(element -> element.length() > 2)
                .collect(Collectors.groupingBy(String::length));
        System.out.println(firstMap);

        //it's possible to specify accumulation collection
        Map<Integer, Set<String>> secondMap = letters
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(secondMap);

        //it's possible to specify map type
        TreeMap<Integer, Set<String>> thirdMap = letters
                .stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(thirdMap);
    }

    //separate into true/false collections
    private static void partitionBy() {
        List<String> letters = Arrays.asList("a", "ba", "ca", "d", "ea", "f");

        //Pay attention! map is never empty, even if lists are empty
        Map<Boolean, List<String>> firstMap = letters
                .stream()
                .filter(element -> element.length() > 2)
                .collect(Collectors.partitioningBy(element -> element.length() == 1));
        System.out.println(firstMap);
    }

    //shows usage of downstream collector
    private static void downstream() {
        List<String> letters = Arrays.asList("a", "ba", "ca", "d", "ea", "f");

        //Pay attention! map is never empty, even if lists are empty
        Map<Integer, String> firstMap = letters
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.joining("; ")));
        System.out.println(firstMap);
    }

    //ok, something insane
    private static void insane() {
        List<String> letters = Arrays.asList("a", "ba", "ca", "d", "ea", "f");

        //Pay attention! map is never empty, even if lists are empty
        Map<Integer, Integer> firstMap = letters
                .stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(
                                element -> element + "z",
                                Collectors.summingInt(String::length))
                        )
                );
        //How do you fill now? =)
        System.out.println(firstMap);
    }

    private static void enthuwareExample() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17); //1
        Stream<Integer> primeStream = primes.stream(); //2
        Predicate<Integer> test = k -> k < 10; //3
        Map<Boolean, Long> booleanCountMap = primeStream.collect(Collectors.partitioningBy(test, Collectors.counting()));
        System.out.println(booleanCountMap);
    }

    public static void main(String[] args) {
        //joinElements();
        //countElements();

        //average();
        //minMaxElement();
        //collectToMap();
        //groupElements();
        //partitionBy();
        //downstream();
        //insane();
        enthuwareExample();
    }
}