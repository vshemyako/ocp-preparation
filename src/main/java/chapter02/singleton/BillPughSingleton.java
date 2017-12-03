package chapter02.singleton;

/**
 * Folks assert that prior to 'Java 5' JVM had lots of problems with memory model and even synchronized or double lock
 * approach ended up in multiple instance creations.
 * Smart guy whose name is William (notwithstanding people call him Bill =)) came up with non-synchronized approach
 * which guarantees one instance creation.
 */
public class BillPughSingleton {

    //Restricts object creation for outer code
    private BillPughSingleton() {
    }

    //Inner static helper class
    //Truly clever
    private static class SingletonHelper {

        static {
            System.out.println("Inner class loaded");
        }

        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    //Getter
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    //Just to test that inner class isn't loaded when methods of the outer class are called
    private static void test() {
        System.out.println("Outer class loaded");
    }

    public static void main(String[] args) {
        test();
    }
}
