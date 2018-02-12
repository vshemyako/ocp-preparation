package chapter03.collections;

import java.util.*;

/**
 * Java Collection Framework is one of the main topics on the OCPJP
 */
public class CollectionFramework {

    public static void main(String[] args) {
        //The main interface in the collection framework is 'Collection'
        Collection<Integer> collection;
        collection = new ArrayList<>();
        collection = new HashSet<>();
        collection = new ArrayDeque<>();

        removeNull();
    }

    public static void removeNull() {
        //It's possible to add null values and remove them without NullPointerException being thrown
        List<Integer> numbers = new ArrayList<>();
        numbers.add(null);
        System.out.println(numbers.remove(null));
    }
}
