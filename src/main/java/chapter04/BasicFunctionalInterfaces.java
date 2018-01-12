package chapter04;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.*;

/**
 * Introduction of basic functional interfaces and their corresponding abstract methods implemented using lambdas and
 * method references
 */
public class BasicFunctionalInterfaces {

    /**
     * Implements {@link Supplier} interface.
     * Supplier's method accepts nothing return object
     */
    public static void supplierExample() {
        Supplier<LocalDate> methodReferenceSupplier = LocalDate::now;
        Supplier<LocalDate> lambdaSupplier = () -> LocalDate.now();

        System.out.println(methodReferenceSupplier.get());
        System.out.println(lambdaSupplier.get());
    }

    /**
     * Shows usage of {@link Consumer} interface.
     * Accepts object, return nothing
     */
    public static void consumerExample() {
        Consumer<String> methodReferenceConsumer = System.out::println;
        Consumer<String> lambdaConsumer = word -> System.out.println(word);

        methodReferenceConsumer.accept("Annie");
        lambdaConsumer.accept("Ronnie");
    }

    /**
     * Shows usage of {@link BiConsumer} interface.
     * Accepts two objects and return nothing
     */
    public static void biConsumerExample() {
        Map<String, String> wordToWordMap = new HashMap<>();
        BiConsumer<String, String> methodReferenceBiConsumer = wordToWordMap::put;
        BiConsumer<String, String> lambdaBiConsumer = (key, value) -> wordToWordMap.put(key, value);

        methodReferenceBiConsumer.accept("first", "one");
        lambdaBiConsumer.accept("second", "two");
        lambdaBiConsumer.accept("third", "three");

        System.out.println(wordToWordMap);
    }

    /**
     * Shows usage of {@link Predicate} interface.
     * Accepts object and returns boolean value
     */
    public static void predicateExample() {
        Predicate<String> methodReferencePredicate = String::isEmpty;
        Predicate<String> lambdaPredicate = word -> word.isEmpty();

        System.out.println(methodReferencePredicate.test(""));
        System.out.println(lambdaPredicate.test(" "));
    }

    /**
     * Shows usage of {@link BiPredicate} interface.
     * Accepts two objects and return boolean value
     */
    public static void biPredicateExample() {
        BiPredicate<String, String> methodReferenceBiPredicate = Objects::equals;
        BiPredicate<String, String> lambdaBiPredicate = (firstWord, secondWord) -> Objects.equals(firstWord, secondWord);

        System.out.println(methodReferenceBiPredicate.test(new String("one"), new String("one")));
        System.out.println(lambdaBiPredicate.test(new String("One"), new String("one")));
    }

    /**
     * Shows usage of {@link Function} interface.
     * Accept one object and converts its value or, possibly, into another object
     */
    public static void functionExample() {
        Function<String, Integer> methodReferenceFunction = String::length;
        Function<String, Integer> lambdaFunction = word -> word.length();

        System.out.println(methodReferenceFunction.apply("Ninety-nine"));
        System.out.println(lambdaFunction.apply("Ninety-nine"));
    }

    /**
     * Shows usage of {@link BiFunction}.
     * Accept two object and converts them into one
     */
    public static void biFunctionExample() {
        BiFunction<String, String, String> methodReferenceBiFunction = String::concat;
        BiFunction<String, String, String> lambdaBiFunction = (firstWord, secondWord) -> firstWord.concat(secondWord);

        System.out.println(methodReferenceBiFunction.apply("Hello", "World!"));
        System.out.println(lambdaBiFunction.apply("Hello", "World!"));
    }

    /**
     * {@link UnaryOperator} example
     */
    public static void unaryOperatorExample() {
        UnaryOperator<String> methodReferenceUnaryOperator = String::toUpperCase;
        System.out.println(methodReferenceUnaryOperator.apply("nope"));
    }

    /**
     * {@link BinaryOperator} example
     */
    public static void binaryOperatorExample() {
        BinaryOperator<String> methodReferenceBinaryOperator = String::concat;
        System.out.println(methodReferenceBinaryOperator.apply("yea", "yes"));
    }

    /**
     * Fires up all interfaces implementations
     */
    public static void main(String[] args) {
        supplierExample();
        consumerExample();
        biConsumerExample();
        predicateExample();
        biPredicateExample();
        functionExample();
        biFunctionExample();
        unaryOperatorExample();
        binaryOperatorExample();
    }
}
