package chapter07;

import java.util.Arrays;

/**
 * Defining a task which thread can execute can be done in two ways:
 * - implementing interface {@link Runnable} instance of which you'll provide into {@link Thread} constructor
 * - create a class that extends {@link Thread}
 */
public class RunnableFirstSteps {

    /**
     * First approach to define a set of tasks
     */
    private static class Printer implements Runnable {
        @Override
        public void run() {
            Iterable<String> words = Arrays.asList("one", "two", "three");
            words.forEach(System.out::println);
        }
    }

    /**
     * Second approach
     */
    private static class Drawer extends Thread {
        @Override
        public void run() {
            Iterable<Integer> numbers = Arrays.asList(1, 2, 3, 4);
            numbers.forEach(System.out::println);
        }
    }

    /**
     * Run a thread
     */
    public static void main(String[] args) {
        //new Thread(new Printer()).start();
        new Drawer().start();
    }
}
