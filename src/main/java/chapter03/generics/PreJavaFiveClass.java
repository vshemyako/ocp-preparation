package chapter03.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Prior to JDK1.5 there was no notion of Generics
 */
public class PreJavaFiveClass {

    private static int getSum(List numbers) {
        int sum = 0;
        for (int index = 0; index < numbers.size(); index++) {
            try {
                //dangerous stuff
                sum += (int) numbers.get(index);
            } catch (ClassCastException exc) {
                System.err.println("Error! Not an int");
            }
        }
        return sum;
    }

    private static int countSum(List<Integer> numbers) {
        int sum = 0;
        for (int index = 0; index < numbers.size(); index++) {
            //compile time check, no cast needed
            sum += numbers.get(index);
        }
        return sum;
    }

    public static void main(String[] args) {
        //No type information
        List numbers = new ArrayList();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        //no compile-time check which later on results in class cast exception being thrown
        System.out.println("Sum: " + getSum(numbers));

        //Type information provided
        List<Integer> digits = new ArrayList<>();
        //Compile time error
        //digits.add("1");
        digits.add(1);
        digits.add(2);
        digits.add(3);
        System.out.println("Sum: " + countSum(digits));
    }
}
