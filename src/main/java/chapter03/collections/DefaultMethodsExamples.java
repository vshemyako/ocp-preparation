package chapter03.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Consequently checks all default collection methods required for OCP exam
 */
public class DefaultMethodsExamples {

    /**
     * {@see java.util.Iterable} has default forEach method
     */
    public static void iterateThroughElements() {
        Iterable<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        Consumer<Integer> printConsumer = System.out::println;
        numbers.forEach(printConsumer);
    }

    /**
     * {@see java.util.Collection} has default removeIf method
     */
    public static void removeElements() {
        Collection<String> words = new ArrayList<>();
        words.add("one");
        words.add("only");
        words.add("bed");
        words.add("between");

        String removeCondition = "o";
        Predicate<String> startsWithPredicate = word -> word.startsWith(removeCondition);

        words.removeIf(startsWithPredicate);
        System.out.println(words);
    }

    /**
     * {@see java.util.List} has default replaceAll method
     */
    public static void replaceElements() {
        List<String> words = new ArrayList<>();
        words.add("one");
        words.add("only");
        words.add("bed");
        words.add("between");

        UnaryOperator<String> changeWords = word -> word.length() < 3 ? word : word.substring(0, 3);

        words.replaceAll(changeWords);
        System.out.println(words);
    }

    /**
     * fires up all methods
     */
    public static void main(String[] args) {
       iterateThroughElements();
       removeElements();
       replaceElements();
    }
}
