package chapter07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Concurrent API presented several classes which support atomic operations, which result in predictable reading/writing
 * operation, though still not ordered
 */
public class AtomicField {

    private static AtomicInteger number;
    static {
        number = new AtomicInteger(0);
    }

    /**
     * Reproducing the same logic, but not with AtomicInteger type field
     */
    private static void incrementValue() {
        System.out.println(number.incrementAndGet());
    }

    /**
     * Runs 10 threads which aren't synchronized between themselves, but operate upon atomic type field
     */
    public static void main(String[] args) {
        ExecutorService serviceWithLotsOfThreads = null;
        try {
            serviceWithLotsOfThreads = Executors.newFixedThreadPool(10);
            for (int index = 0; index < 10; index++) {
                serviceWithLotsOfThreads.submit(AtomicField::incrementValue);
            }
        } finally {
            if (serviceWithLotsOfThreads != null) {
                serviceWithLotsOfThreads.shutdown();
            }
        }
    }
}
