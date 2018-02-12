package chapter03.generics;

import java.util.List;

/**
 * There are several restrictions considering generics
 */
public class GenericRestrictions<T> {

    // 1st - cannot instantiate 'generic' type with 'primitive' type
    public static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class PairTester {
        public static void main(String[] args) {
            //impossible to substitute generic types with primitive types
            //Pair<int, double> pair = new Pair<int, double>(10, 20.0);

            //use 'wrappers' instead
            Pair<Integer, Double> pair = new Pair<>(10, 20.0);
        }
    }

    // 2nd - cannot create an instance of 'type' parameter
    public static <E> void instanceOfType() {
        //compile error
        //E element = new E();
    }

    // 3rd - cannot create static fields of 'type' parameter
    // static fields are class-level members, therefore it is restricted
    //public static T notAllowed;

    // 4rd - cannot use 'instanceof' and 'casts'
    public static <E> boolean compareTypes(List<E> list) {
        //return list instanceof List<Integer>;

        //only wildcards are allowed
        return list instanceof List<?>;
    }

    // 5th - cannot create array of 'parameterized' types
    public static void impossibleArrays() {
        //ArrayList<Integer>[] arrayLists = new ArrayList<Integer>[4];
    }

    // 6th - cannot extend directly or indirectly 'Throwable' class, cannot catch parameterized object
    public static <T extends Exception, J> void execute(List<J> jobs) {
        //compile time error
        //try {
        //} catch (T e) {
        //}
    }

    // 7th - cannot overload method with a formal parameter types
    // after type erasure they will be of the same type
    //public static void acceptList(List<Integer> integers) {}
    //public static void acceptList(List<String> integers) {}
}
