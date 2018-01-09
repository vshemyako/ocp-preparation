package chapter03.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * There are several default methods in Map interface which are in the OCP exam objectives
 */
public class MapInterface {

    public static void main(String[] args) {

        Map<String, Integer> numbersMap = new HashMap<>();
        numbersMap.put("one", null);
        numbersMap.put("one", 1);
        numbersMap.put("two", 2);

        System.out.println(numbersMap);
    }
}
