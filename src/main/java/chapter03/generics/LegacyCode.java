package chapter03.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Older code examples which can lead to a class cast exception beign thrown at runtime
 */
public class LegacyCode {

    private static void allowRawTypes(List<Integer> numbers) {
        for (Integer integer : numbers) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        List strings = new ArrayList();
        strings.add("one");

        //we are passing a list of strings to a method which declares a list of integers
        //compile-time safety doesn't work
        allowRawTypes(strings);
    }

    //using raw types can even lead to a compile-time error
    public void compileTimeError() {
        List numbers = new ArrayList();
        numbers.add(10);

        //compiler treats our objects as of type 'Object'
        //therefore - compile time error
        //int firstNumber = numbers.get(0);
    }
}
