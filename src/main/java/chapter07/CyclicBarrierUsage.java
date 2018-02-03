package chapter07;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Sometimes its important to coordinate work of several threads. For this purpose Concurrency API introduced
 * {@link java.util.concurrent.CyclicBarrier} class. It is called cyclic because after several threads were released
 * the same barrier can be used once again.
 */
public class CyclicBarrierUsage {

    private static final String READY = "Ready?!";
    private static final String STEADY = "Steady?!";
    private static final String GO = "Go!";

    //Let's say we have several methods, which should be processed subsequently

    /**
     * Prints passed messaged
     */
    private static void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Coordinates each thread with specified barriers
     */
    private static void barrierController(CyclicBarrier firstBarrier, CyclicBarrier secondBarrier) {
        try {
            printMessage(READY);
            firstBarrier.await();
            printMessage(STEADY);
            secondBarrier.await();
            printMessage(GO);
        } catch (InterruptedException | BrokenBarrierException e) {
            //Some log.error message
        }
    }

    /**
     * Creates several threads and pushes them to work
     */
    public static void main(String[] args) {
        //First type constructor just specifies for how much threads barrier is created
        CyclicBarrier firstBarrier = new CyclicBarrier(4);
        //Second type constructor allows to specify an instance of Runnable which will be called before thread are released
        CyclicBarrier secondBarrier = new CyclicBarrier(4, () -> System.out.println("And Race BEGINS!"));

        //How beautiful it is
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(4);
            for (int index = 0; index < 4; index++) {
                //Output confirms that threads are coordinated
                executorService.submit(() -> barrierController(firstBarrier, secondBarrier));
            }
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }
}
