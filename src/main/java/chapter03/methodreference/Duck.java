package chapter03.methodreference;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Class to demonstrate method references usage
 */
public class Duck {
    public String name;
    public Integer age;

    public Duck(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {

        // static method references and lambdas
        // implementing comparator interface using lambdas
        Comparator<Duck> ageComparator = (o1, o2) -> DuckHelper.compareByAge(o1, o2);

        // implementing comparator interface using method reference
        Comparator<Duck> ageMethodReferenceComparator = DuckHelper::compareByAge;

        // consumer example using lambdas
        Consumer<List<String>> sortingConsumer = list -> Collections.sort(list);

        // consumer example using method reference
        Consumer<List<String>> sortingMethodReferenceConsumer = Collections::sort;
    }
}
