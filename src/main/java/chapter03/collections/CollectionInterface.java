package chapter03.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Although {@see java.util.Iterable} is the top interface in the collection framework, JDK treats
 * {@see java.util.Collection} as being the root collection interface. It methods will be examined here.
 */
public class CollectionInterface {

    public static void main(String... args) {
        Collection<Number> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(22);
        numbers.add(33);
        numbers.add(44);
        numbers.add(null);

        //Query methods
        size(numbers);
        isEmpty(numbers);
        contains(numbers, null);
        toArray(numbers);

        //Modification methods
        add(numbers, 55);
        remove(numbers, 22);

        //Bulk methods
    }

    //As one may see methods below accepts Collection's interface instances
    //Query methods
    public static void size(Collection<Number> numbers) {
        System.out.println(numbers.size());
    }

    public static void isEmpty(Collection<Number> numbers) {
        System.out.println(numbers.isEmpty());
    }

    public static void contains(Collection<Number> numbers, Number number) {
        System.out.println(numbers.contains(number));
    }

    public static void toArray(Collection<Number> numbers) {
        //Object type array is returned which is not very convenient
        Object[] array = numbers.toArray();

        //It's possible to return array of specified type
        Integer[] digits = numbers.toArray(new Integer[0]);
    }

    //Modification methods
    //As one may see 'add' and 'remove' methods return boolean primitive designating success of the operation performed
    public static void add(Collection<Number> numbers, Number number) {
        System.out.println(numbers.add(number));
    }

    public static void remove(Collection<Number> numbers, Number number) {
        System.out.println(numbers.remove(number));
    }

    //Bulk methods
    //Splendid bulk operations to perform 'intersection' operations over a collection
    //Actually methods names are self-explanatory
    public static void containsAll(Collection<Number> firstCollection, Collection<Number> secondCollection) {
        System.out.println(firstCollection.containsAll(secondCollection));
    }

    public static void addAll(Collection<Number> firstCollection, Collection<Number> secondCollection) {
        System.out.println(firstCollection.addAll(secondCollection));
    }

    public static void removeAll(Collection<Number> firstCollection, Collection<Number> secondCollection) {
        System.out.println(firstCollection.removeAll(secondCollection));
    }

    public static void retainAll(Collection<Number> firstCollection, Collection<Number> secondCollection) {
        System.out.println(firstCollection.retainAll(secondCollection));
    }

    public static void clear(Collection<Number> numbers) {
        numbers.clear();
    }

    public static void removeIf(Collection<Number> numbers) {
        //Removes elements which satisfy the condition
        numbers.removeIf(number -> number.intValue() % 2 == 0);
    }

    //Methods returning Stream type object. Will be examined later
    public static void stream(Collection<Number> numbers) {
        Stream<Number> stream = numbers.stream();
        Stream<Number> parallelStream = numbers.parallelStream();

    }
}
