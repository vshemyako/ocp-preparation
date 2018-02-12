package chapter04;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * JDK 1.8 presented new class {@link java.util.Optional} which represents a container possibly containing null value
 */
public class LearningOptional {

    /**
     * Lists all possibilities of Optional creation
     */
    public static void createOptional() {
        Optional<Double> optionalObject = Optional.<Double>empty();
        System.out.println("Empty optional object: " + optionalObject);

        //Constructs Optional potentially containing null reference
        Optional<Integer> potentiallyEmptyOptional = Optional.ofNullable(null);
        System.out.println("Potentially empty optional object: " + potentiallyEmptyOptional);

        //It's impossible to create Optional object with 'null' value -> exception is being thrown; use ofNullable instead
        Optional<String> nonNullOptional = Optional.of("value");
        System.out.println("Non-null optional object: " + nonNullOptional);
    }

    /**
     * Demonstrates different approaches for value retrieval from Optional
     */
    public static void retrieveValueFromOptional() {
        //It's safe to call toString() method but additional check has to made before retrieval
        Optional<Object> nullValueWithin = Optional.empty();
        System.out.println(nullValueWithin);

        try {
            nullValueWithin.get();
        } catch (NoSuchElementException ex) {
            System.out.println("Don't do this: " + ex.getMessage());
        }

        //This approach only differs in a way that object is being created
        Optional<Object> ofNullableOptional = Optional.ofNullable(null);
        if(ofNullableOptional.isPresent()) {
            System.out.println(ofNullableOptional.get());
        } else {
            System.out.println("Optional doesn't contain value");
        }

        //More easy way to print a value contained within
        ofNullableOptional.ifPresent(System.out::println);

        //More realistic approaches
        //It's really common for an object to contain null reference
        //Therefore there are bunch of methods to handle such cases
        System.out.println(ofNullableOptional.orElse("Hello from nullable!"));

        //We need to construct a Supplier over here:
        System.out.println(ofNullableOptional.orElseGet(() -> "Supplier in action!"));

        //Or we can ever throw our own exception using supplier
        try {
            ofNullableOptional.orElseThrow(() -> new NoSuchElementException("We dont have any element contained within"));
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        createOptional();
        retrieveValueFromOptional();
    }
}
