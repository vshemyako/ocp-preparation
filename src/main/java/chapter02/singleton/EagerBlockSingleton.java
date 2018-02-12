package chapter02.singleton;

/**
 * Eager singleton pattern is not the best one - it doesn't handle situations in which exceptions occur during
 * object creation. A step further - instantiate object in a static block
 */
public class EagerBlockSingleton {

    //Restricts object creation for outer code
    private EagerBlockSingleton() {
    }

    //Singleton
    private static final EagerBlockSingleton INSTANCE;

    //It's possible to add more logic
    static {
        try {
           INSTANCE = new EagerBlockSingleton();
        } catch(Exception exc) {
            throw new RuntimeException("Error occurred during object creation");
        }
    }

    //Getter
    public static EagerBlockSingleton getInstance() {
        return INSTANCE;
    }
}
