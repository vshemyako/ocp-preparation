package chapter03.methodreference;

import java.util.function.Predicate;

/**
 * It's possible to construct method reference without knowing about class instance until runtime
 */
public class RuntimeMethodReference {

    public static void main(String[] args) {

        // runtime lambda
        Predicate<String> runtimeLambda = s -> s.isEmpty();

        // runtime method reference
        Predicate<String> methodReferenceLambda = (s) -> s.isEmpty();
    }
}
