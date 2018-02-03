package chapter07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Oracle suggests to use {@link java.util.concurrent.ExecutorService} interface to work with threads. In order to obtain
 * an instance of this interface one have to use {@link java.util.concurrent.Executors} factory
 */
public class ExecutorServiceIntroduction {

    /**
     * Lets test usage of {@link java.util.concurrent.ExecutorService}, in particular single threaded service.
     * Single threaded executor quarantines that tasks will be executed sequentially.
     */
    public static void main(String[] args) {

        ExecutorService service = null;
        try {
            System.out.println("Main - start");
            service = Executors.newSingleThreadExecutor();
            service.execute(() -> System.out.println("Service - start"));
            service.execute(() -> IntStream.range(1, 6).forEach(System.out::println));
            service.execute(() -> System.out.println("Service - end"));
            System.out.println("Main - end");
        } finally {
            if (service != null) {
                //remember! this thread isn't a 'daemon' one
                service.shutdown();
            }
        }

    }
}
