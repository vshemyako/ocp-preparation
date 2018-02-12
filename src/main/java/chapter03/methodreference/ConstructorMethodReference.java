package chapter03.methodreference;

import java.util.function.Supplier;

/**
 * Constructor method reference differs from previous method reference as it uses new keyword instead of method
 * invocation
 */
public class ConstructorMethodReference {

    public static void main(String[] args) {

        // lambda
        Supplier<String> lambdaSupplier = () -> new String();

        // method reference
        Supplier<String> methodReferenceSupplier = String::new;
    }
}
