package chapter03.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Lower generics bounds present a problem with immutability. Lower bounds come to the rescue!
 */
public class LowerBounds {

    public static void playWithBounds() {
        lowerBound(new ArrayList<Integer>());
        lowerBound(new ArrayList<Object>());

        upperBound(new ArrayList<Integer>());
        upperBound(new ArrayList<Number>());
        //upperBound(new ArrayList<Object>());

        wildCard(new ArrayList<Integer>());
        wildCard(new ArrayList<Number>());
        wildCard(new ArrayList<Object>());
    }

    //Lower-bound is mutable
    public static void lowerBound(List<? super Integer> objects) {
        objects.add(new Integer(10));
    }

    //Upper-bound list is immutable
    public static void upperBound(List<? extends Number> objects) {
        //objects.add(new Integer(10));
    }

    //Wildcard list is immutable
    public static void wildCard(List<?> objects) {
        //objects.add(new Integer(10));
    }
}
