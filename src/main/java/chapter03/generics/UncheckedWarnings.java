package chapter03.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Mixing raw and parameterized types may lead to compile warning. OCP requires to know when those occur
 */
public class UncheckedWarnings {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);

        //adding element to a raw type object result in compilation warning
        List objects = new ArrayList<>();
        objects.add(10);

        //'narrowing' types result in compilation warning
        numbers = objects;
    }
}
