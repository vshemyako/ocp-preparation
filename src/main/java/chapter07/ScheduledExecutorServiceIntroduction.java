package chapter07;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Demonstrates usage of {@link java.util.concurrent.ScheduledExecutorService} which implements
 * {@link java.util.concurrent.ExecutorService} and adds methods related to delayed and periodic execution
 */
public class ScheduledExecutorServiceIntroduction {

    public static final int SEED_FOR_RANDOM = 100;
    public static final int INITIAL_DELAY = 0;
    public static final int PERIOD = 3;

    /**
     * Instance of scheduled executor can also be retrieved from {@link java.util.concurrent.Executors} factory methods
     */
    private static void scheduleCallable() {
        ScheduledExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadScheduledExecutor();
            ScheduledFuture<Integer> scheduledResult =
                    executorService.schedule(() -> IntStream.rangeClosed(1, 100).sum(), 5, TimeUnit.SECONDS);
            System.out.println("Scheduled result is: " + scheduledResult.get());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("I have to admit, that exception has been thrown, guys");
        } finally {
            //Once again! Don't forget to shutdown non-daemon threads
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    /**
     * Prints out some random numbers each period of time
     */
    private static void schedulePeriodicRunnable() {
        ScheduledExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadScheduledExecutor();
            ScheduledFuture<?> futureWithNoResult = executorService.scheduleAtFixedRate(
                    () -> System.out.println(Math.random() * SEED_FOR_RANDOM),
                    INITIAL_DELAY, PERIOD,
                    TimeUnit.SECONDS
            );
            futureWithNoResult.get();
            Thread.sleep(10000);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("There's no beginning, there's no end. There's only change");
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    /**
     * As always, just an entry point
     */
    public static void main(String[] args) {
        scheduleCallable();
        schedulePeriodicRunnable();
    }
}
