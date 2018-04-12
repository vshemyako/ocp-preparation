package enthuware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Thought about Runtime exception which actually worked fine
 */
public class RawCollection {

    public static void main(String[] args) {
        List<String> whatever = new ArrayList<>();
        fillCollection(whatever);
        //exception is being throws on retrieve operation
        whatever.forEach(System.out::println);
    }

    //hm, worked as I thought
    private static void fillCollection(List collection) {
        collection.add(1);
        collection.add("1");
        collection.add(1L);
        collection.add(new HashMap<>());
    }
}
