package chapter03.generics;

/**
 * Some crazy looking syntax examples
 */
public class GenericMethods {

    //Generic method in a not generic class
    public static <T> void doNotReturn(T t) {
    }

    //Again it's legal
    public static <T> T doReturn(T t) {
        return t;
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
