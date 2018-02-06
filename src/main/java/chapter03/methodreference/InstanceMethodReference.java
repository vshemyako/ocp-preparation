package chapter03.methodreference;

import java.util.function.Predicate;

/**
 * Another type of method references which are called upon instances
 */
public class InstanceMethodReference {

    public static void main(String[] args) {

        String name = "Valentine";
        // lambda
        Predicate<String> startsWithPredicate = prefix -> name.startsWith(prefix);

        // method reference
        Predicate<String> startsWithMethodReferencePredicate = name::startsWith;
    }
}
