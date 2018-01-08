package chapter03.methodreference;

/**
 * Helper class to compare {@see Duck} objects
 */
public class DuckHelper {

    // no getters to omit boilerplate code
    public static int compareByAge(Duck o1, Duck o2) {
        return o1.age - o2.age;
    }

    public static int compareByName(Duck o1, Duck o2) {
        return o1.name.compareTo(o2.name);
    }
}
