package chapter03.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Upper generics bound is specified using 'extend' keyword
 */
public class UpperBounds {

    public static void playWithUpperBound() {
        //Proper way
        List<? extends Number> numbers;
        numbers = new ArrayList<Number>();
        numbers = new ArrayList<Double>();
        numbers = new ArrayList<Float>();
        numbers = new ArrayList<Long>();
        numbers = new ArrayList<Integer>();

        //Improper way
        List<Number> invalidNumbers;
        invalidNumbers = new ArrayList<Number>();
        //don't do this please
        /*
        invalidNumbers = new ArrayList<Double>();
        invalidNumbers = new ArrayList<Float>();
        invalidNumbers = new ArrayList<Long>();
        invalidNumbers = new ArrayList<Integer>();
        */
    }

    public static void unobviousMethods() {
        List<? extends Number> numbers = new ArrayList<Integer>();
        //One may ask: why does this work the way it works?
        //wildcard and upperbound collections are immutable in java
        //they can be assigned a collection which is a subtype of declared unbound, but after that its become immutable
        /*
        numbers.add(new Integer(2));
        numbers.add(new Double(2));
        */
    }
}
