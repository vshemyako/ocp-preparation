package chapter04;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Some edge cases a programmer should be aware of
 */
public class EdgeCasesFunctionalProgramming {

    /**
     * Streams are not evaluated until first method invocation
     */
    public static void streamAndUnderlyingData() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        Stream<Integer> streamOfNumbers = numbers.stream();
        numbers.add(40);

        //prints out 4
        //remember! streams are lazily evaluated
        System.out.println(streamOfNumbers.count());
    }

    /**
     * Prints out converted number
     */
    public static void printOutNumber(String number) {
        Optional<String> word = Optional.of(number);
        word.map(Integer::parseInt)
                .filter(value -> value < 10)
                .ifPresent(System.out::println);
    }

    /**
     * Tests chosen method
     */
    public static void main(String[] args) {
        streamAndUnderlyingData();
        printOutNumber("9");
        printOutNumber("10");
    }
}
