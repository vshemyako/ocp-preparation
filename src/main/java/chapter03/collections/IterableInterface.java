package chapter03.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;

/**
 * In previous commit I've made a mistake affirming that {@see java.util.Collection} is the main interface in the
 * Collection framework. Actually since JDK1.5 Iterable is at the top of that structure. JDK1.8 added several default
 * methods which will be examined here.
 */
public class IterableInterface {

    public static void iterableTest() {
        //As one may see iterator can be retrieved from within any collection object
        Iterable<String> iterable = Arrays.asList("third", "second", "first");
        Iterator<String> iterator = iterable.iterator();

        //Iterating over a collection
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //One may simply use forEach default method from Iterable interface
        //Truly beautiful
        iterable.forEach(System.out::println);

        //One may almost never deal with spliterator() method; only if you'd like to create your own Collection type
        //spliterator offers means by which it's easy to operate over a part of a collection (used in parallelizing)
        Spliterator<String> spliterator = iterable.spliterator();
    }

    public static void main(String[] args) {
        iterableTest();
    }
}
