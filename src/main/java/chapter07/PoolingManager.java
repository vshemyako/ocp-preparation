package chapter07;

/**
 * Its possible to define for how long a {@link Thread} have to wait in order to proceed execution
 */
public class PoolingManager {

    private static int number = 0;

    /**
     * Shows usage of {@link Thread#sleep(long)} method
     */
    public static void main(String[] args) {
        new Thread(() -> {
            while (number < 200) {
                number++;
            }
        }).start();

        while (number < 10) {
            try {
                Thread.sleep(100);
                System.out.println("Check once again!");
            } catch (InterruptedException ex) {
                System.err.println("Something went wrong!");
            }
        }
    }
}
