package chapter07;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Examples from tests
 */
public class Examples {

    public static Integer performCount(int exhibitNumber) {
        throw new RuntimeException();
    }

    public static void printResults(Future<?> f) {
        try {
            f.get();
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        final List<Future<?>> results = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(i -> results.add(service.submit(() -> performCount(i))));
        results.stream().forEach(f -> printResults(f));
        service.shutdown();
    }
}
