package chapter02.singleton;

/**
 * Singleton pattern for lightweight classes
 */
public class EagerSingleton {

    //Restricts object creation for outer code
    private EagerSingleton(){}

    //Singleton
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    //Getter
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
