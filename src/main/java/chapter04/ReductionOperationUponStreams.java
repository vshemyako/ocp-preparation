package chapter04;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Not all reduction operations were mentioned in previous commit
 */
public class ReductionOperationUponStreams {

    //Shows reduction logic without using streams
    public static void reduceManual() {
        String[] letters = new String[]{"h", "e", "l", "l", "o"};
        String word = "";
        for (String letter : letters) {
            word += letter;
        }

        System.out.println(word);
    }

    //The same things can be implemented using streams
    public static void reduceUsingStream() {
        Stream<String> letters = Stream.of("h", "e", "l", "l", "o");
        String word = letters.reduce("", String::concat);

        System.out.println(word);
    }

    //Reduction operation upon streams
    public static void multiplicationUsingStream() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7);
        Integer result = numbers.reduce(1, Math::multiplyExact);
        System.out.println(result);
    }

    //It's obvious that reduce function have to have signature without requirements of initial identity
    public static void reduceUsingStreamWithoutInitialIdentity() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7);
        Optional<Integer> result = numbers.reduce(Math::multiplyExact);
        result.ifPresent(System.out::println);
    }

    //More advanced reduction feature
    public static void reduceParallel() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7);
        Integer result = numbers.reduce(1, Math::multiplyExact, Math::multiplyExact);
        System.out.println(result);
    }

    //Fires up desired method
    public static void main(String[] args) {
        reduceManual();
        reduceUsingStream();
        multiplicationUsingStream();
    }
}
