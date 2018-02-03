package chapter07.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Sometimes there's a need to subdivide a huge task into several ones. To this end Concurrency API introduces
 * {@link java.util.concurrent.ForkJoinTask} abstract class which has two direct extensions:
 * - {@link java.util.concurrent.RecursiveTask}
 * - {@link java.util.concurrent.RecursiveAction}
 */
public class RecursiveActionUsageExample {
    /**
     * Output shows that our huge tasks was divided into 4 smaller ones
     */
    public static void main(String[] args) {
        ForkJoinTask<?> taskToDivide = new WordsSupplier(1, 10);
        ForkJoinPool poolToUse = new ForkJoinPool();
        poolToUse.invoke(taskToDivide);

        //WordsSupplier.getWords().forEach(System.out::println);
    }
}

class WordsSupplier extends RecursiveAction {
    private static List<String> words;

    static {
        words = new ArrayList<>();
    }

    private int lowerLimit;
    private int upperLimit;

    public WordsSupplier(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public static List<String> getWords() {
        return words;
    }

    /**
     * Subdivides huge task into smaller once
     */
    @Override
    protected void compute() {
        if (upperLimit - lowerLimit < 3) {
            System.out.format("Smaller task. Lower limit: %s, upper limit: %s%n", lowerLimit, upperLimit);

            while (lowerLimit <= upperLimit) {
                words.add(String.valueOf(Math.random()));
                lowerLimit++;
            }
        } else {
            System.out.format("Huge task to subdivide. Lower limit: %s, upper limit: %s%n", lowerLimit, upperLimit);
            int middleLimit = (lowerLimit + upperLimit) / 2;
            invokeAll(new WordsSupplier(lowerLimit, middleLimit), new WordsSupplier(middleLimit + 1, upperLimit));
        }
    }
}