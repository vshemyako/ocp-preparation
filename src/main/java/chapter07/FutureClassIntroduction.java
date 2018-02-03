package chapter07;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * As documentation asserts {@link java.util.concurrent.Future} objects represent result of asynchronous task
 */
public class FutureClassIntroduction {

    /**
     * Demonstrate basic usage of 'Future' type object
     */
    private static void waitForFuture() {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            Future<?> result = executorService.submit(() -> IntStream.rangeClosed(1, 1000).forEach(System.out::print));
            //wait for a async result for specified amount of time
            result.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.err.println("Future object result ended up with an exception");
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    /**
     * Reproducing {@link #waitForFuture()} method using {@link java.util.concurrent.Callable} interface
     */
    private static void waitForFutureCall() {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            Future<Integer> result = executorService.submit(() -> IntStream.rangeClosed(1, 1000).sum());
            //Endlessly wait for a result
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Future object result ended up with an exception");
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    /**
     * Just waits for a future to come =)
     */
    public static void main(String[] args) {
        waitForFuture();
        waitForFutureCall();
    }
}
