package chapter02.singleton;

/**
 * Lazy singleton is perfect for one-thread applications. But in multi-threaded environments several threads can occur
 * in the 'if' block at the same time resulting in multiple instance creation. To prevent this 'synchronized' keyword is
 * used.
 */
public class ThreadSafeSingleton {

    //Restricts object creation for outer code
    private ThreadSafeSingleton(){}

    //Singleton
    private static ThreadSafeSingleton instance;

    //Getter
    public static synchronized ThreadSafeSingleton getInstance() {
        if(instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
