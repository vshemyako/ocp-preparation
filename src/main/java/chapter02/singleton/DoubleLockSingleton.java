package chapter02.singleton;

/**
 * The biggest flaw of 'Thread safe singleton' is that it reduces performance of an application.
 * Actually we need thread safety only for several first instance retrievals.
 * 'Double lock singleton' offers solution to this problem.
 */
public class DoubleLockSingleton {

    //Restricts object creation for outer code
    private DoubleLockSingleton() {
    }

    //Singleton
    private static DoubleLockSingleton instance;

    //Getter
    public static DoubleLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleLockSingleton();
                }
            }
        }
        return instance;
    }
}
