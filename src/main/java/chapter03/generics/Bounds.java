package chapter03.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Bounds is the most complicated part of generics which will be disclosed here
 */
public class Bounds {

    public static void acceptObjectList(List<Object> objects) {
    }

    //That's the proper way to accept lists of any type
    public static void acceptAnyList(List<?> objects) {
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        //one may suppose that 'List<Object>' will accept any type of a list
        //that is not true
        //acceptObjectList(strings);
        //acceptObjectList(numbers);

        //the reason of such behavior is the following:
        //that's not valid:
        //List<Object> objects = new ArrayList<String>();

        //indeed accepts everything
        acceptAnyList(strings);
        acceptAnyList(numbers);

        arrayExample();
    }

    public static void arrayExample() {
        //Wow! What?
        //As you see simple arrays behave differently from they collection counterparts
        Object[] array = new Integer[3];
        try {
            //Runtime exception ladies and gentlemen
            array[0] = "one";
        } catch (ArrayStoreException exc) {
            System.out.println("I've told you!");
        }
    }
}
