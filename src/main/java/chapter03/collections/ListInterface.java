package chapter03.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * List interface exhibits means to work with sequences of objects which allows duplicates.
 */
public class ListInterface {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Annie");
        list.add("Bob");
        list.add("Clark");
        list.add("Don");
    }
}
