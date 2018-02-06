package chapter03.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Reviewing 'generics' bounds
 */
public class AllGenericBounds {

    public static void main(String[] args) {

        // Upper bound
        // Therefore it's not possible to add any type of objects
        // But it's possible to retrieve objects of upper bound type
        List<? extends Number> numberClassList;
        numberClassList = new ArrayList<Number>();
        numberClassList = new ArrayList<Integer>();
        numberClassList = new ArrayList<Double>();

        // Lower bound
        List<? super Integer> integerClassList;
        integerClassList = new ArrayList<Integer>();
        integerClassList = new ArrayList<Number>();
        integerClassList = new ArrayList<Object>();
    }
}
