package chapter04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Testing different examples
 */
public class Examples {

    private static void first() {
        Predicate<? super String> predicate = (String s) -> s.length() > 3;
        Stream<String> stream = Stream.iterate("-", (s) -> s + s);
        boolean b1 = stream.noneMatch(predicate);
        boolean b2 = stream.anyMatch(predicate);
        System.out.println(b1 + " " + b2);
    }

    private static void second() {
        Stream.generate(() -> "1").limit(10).peek(System.out::println).forEach(System.out::println);
    }

    private static void compute() {
        List<Integer> ls = Arrays.asList(3, 4, 6, 9, 2, 5, 7);
        System.out.println(ls.stream().max(Integer::max).get());
    }

    public static void main(String[] args) {
        compute();
        //second();
    }
}
