package chapter03.collections;

import java.util.*;

/**
 * There are several default methods in Map interface which are in the OCP exam objectives
 */
public class MapInterface {

    public static void main(String[] args) {

        Map<String, Integer> numbersMap = new HashMap<>();
        numbersMap.put("one", null);
        numbersMap.put("one", 1);
        numbersMap.put("two", 2);

        //System.out.println(numbersMap);

        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("One");
        strings.add("1");

        Collections.sort(strings);
        //System.out.println(strings);

        ArrayDeque<?> objects = new ArrayDeque<String>();

        Map<String, Number> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.forEach((s, number) -> System.out.println("Key: " + s + " Value: " + number));
    }
}