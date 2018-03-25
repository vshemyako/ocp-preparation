package chapter03.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Some crazy looking syntax examples
 */
public abstract class GenericMethods {

    //Generic method in a not generic class
    public static <T> void doNotReturn(T t) {
    }

    //Again it's legal
    public static <T> T doReturn(T t) {
        return t;
    }

    public abstract <U extends Number> Collection<? super Number> doReturn(List<? super Integer> list);

    public static <E extends CharSequence> List<? super E> doIt(List<E> nums) {
        return null;
    }

    //Obviously this is not legal
    /*
    public T againReturn(T t) {
        return t;
    }
    */

    public static void main(String[] args) {
        //Crazy syntax - here it goes
        System.out.println(GenericMethods.<Integer>doReturn(10));
        System.out.println(GenericMethods.<Long>doReturn(10L));

        //Or more simply
        System.out.println(GenericMethods.doReturn(10));
        System.out.println(doReturn(10));

        List<?> resultUnknown = doIt(new ArrayList<String>());
        //unexpected but its clever if you think a little
        //List<Object> resultObject = doIt(new ArrayList<String>());
        List resultWithoutGeneric = doIt(new ArrayList<String>());
    }
}

//The simplest example of a generic class
class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Box<T> createBox(T t) {
        return new Box<>(t);
    }

    public <U> T ignoreParameter(T t, U u) {
        return t;
    }

    public T doNotIgnore(T t) {
        return t;
    }
}
