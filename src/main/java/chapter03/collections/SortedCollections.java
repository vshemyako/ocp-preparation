package chapter03.collections;

import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Review some exotic methods of sorted collections and other edge cases
 */
public class SortedCollections {

    private static void sublist() {
        List<Integer> list = IntStream
                .rangeClosed(1, 20)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> sublist = list.subList(0, 10);
        //Doesn't result in exception
        sublist.add(50);
        System.out.println(sublist);
        System.out.println(list);
    }

    private static void treeSetExperiments() {
        List<Integer> list = IntStream
                .rangeClosed(1, 20)
                .boxed()
                .collect(Collectors.toList());

        TreeSet<Integer> integerTreeSet = new TreeSet<>(list);
        System.out.println(integerTreeSet);

        //Exotic subset methods. Doesn't allow to add elements outside specified subset range
        NavigableSet<Integer> subset = integerTreeSet.subSet(0, true, 5, true);
        System.out.println(subset);

    }

    public static void main(String[] args) {
        //sublist();
        treeSetExperiments();
    }
}
