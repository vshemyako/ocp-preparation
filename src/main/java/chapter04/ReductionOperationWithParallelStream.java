package chapter04;

import java.util.Arrays;
import java.util.List;

public class ReductionOperationWithParallelStream {

    private static void reduce() {
        List<String> vals = Arrays.asList(
                "a", "b", "c", "d", "e", "f", "g",
                "a", "b", "c", "d", "e", "f", "g",
                "a", "b", "c", "d", "e", "f", "g",
                "a", "b", "c", "d", "e", "f", "g");

        String join = vals.parallelStream()
                .peek((x) -> {
                    System.out.println(x + " " + Thread.currentThread().getName());
                })
                .reduce(
                        "_",
                        (a, b) -> {
                            System.out.println("reducing " + a + " and " + b + " Thread: " + Thread.currentThread().getName());
                            return a.concat(b);
                        },
                        (a, b) -> {
                            System.out.println("combining " + a + " and " + b + " Thread: " + Thread.currentThread().getName());
                            return a.concat(b);
                        });
        System.out.println(join);
    }

    public static void main(String[] args) {
        assert false : 1;
        reduce();
    }
}
