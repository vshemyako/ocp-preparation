package chapter06;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Sometimes it's necessary to catch several exceptions types which are not from the same hierarchy, but which are
 * related to a common problem. JDK1.7 present new approach to reduce extra code for doing this
 */
public class MutliCatchClose {

    public static void basicMultiCatch() {
        try {
            //do something
        } catch (NullPointerException | IllegalArgumentException ex) {
            System.out.println("Check your logic!");
        }

        //illegal syntax
        try {
            //do something
        } catch (NullPointerException ex,IllegalArgumentException ex){
            System.out.println("Only one local variable shared among exception types!");
        }

        //illegal syntax
        try {
            //do something
        } catch (NullPointerException ex1,IllegalArgumentException ex2, ArrayIndexOutOfBoundsException ex3){
            System.out.println("Only one local variable shared among exception types!");
        }

        //types have to be from different exception hierarchies
        try {
            //do something
        } catch (FileNotFoundException,IOException ex){
            System.out.println("No hierarchical relation between exception types!");
        }
    }
}
