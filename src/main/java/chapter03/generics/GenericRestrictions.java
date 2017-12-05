package chapter03.generics;

/**
 * There are several limitations that you cannot do with generics
 */
public class GenericRestrictions<T> {

    //declare static fields of generic types
    //it's obvious because static field is linked to a class
    //private static T staticField;

    public void constructorCall() {
        //will be substituted with 'Object' which has no sense
        //new T();
    }

    public void createArray() {
        T[] array;
    }
}
