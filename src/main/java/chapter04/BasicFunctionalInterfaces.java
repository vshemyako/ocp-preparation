package chapter04;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Introduction of basic functional interfaces and their corresponding abstract methods implemented using lambdas and
 * method references
 */
public class BasicFunctionalInterfaces {

    /**
     * Implements Supplier interface.
     * Supplier's method accepts nothing return object
     */
    public static void supplierExample() {
        Supplier<LocalDate> methodReferenceSupplier = LocalDate::now;
        Supplier<LocalDate> lambdaSupplier = () -> LocalDate.now();

        System.out.println(methodReferenceSupplier.get());
        System.out.println(lambdaSupplier.get());
    }

    /**
     * Shows usage of Consumer interface.
     * Accepts object, return nothing
     */
    public static void consumerExample() {
        Consumer<String> methodReferenceConsumer = System.out::println;
        Consumer<String> lambdaConsumer = word -> System.out.println(word);

        methodReferenceConsumer.accept("Annie");
        lambdaConsumer.accept("Ronnie");
    }

    /**
     * Shows usage of BiConsumer interface.
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
     * Fires up all interfaces implementations
     */
    public static void main(String[] args) {
        supplierExample();
        consumerExample();
        biConsumerExample();
    }
}
