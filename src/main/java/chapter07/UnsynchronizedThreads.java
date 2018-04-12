package chapter07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* Demonstrates what happens when multiple threads share the same variable
 */
public class UnsynchronizedThreads {

    private static int number;

    /**
     * Access to the shared variable isn't ordered in any way, operation may increment the same value multiple times
     */
    private void incrementValue() {
        synchronized (this) {
            System.out.print(++number + " ");
        }
    }

    /**
     * Runs 10 threads which aren't synchronized between themselves
     */
    public static void main(String[] args) {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(10);
            UnsynchronizedThreads threads = new UnsynchronizedThreads();
            for (int index = 0; index < 10; index++) {
                executorService.submit(threads::incrementValue);
            }
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }
}
