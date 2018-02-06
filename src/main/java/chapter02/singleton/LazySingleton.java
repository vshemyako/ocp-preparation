package chapter02.singleton;

/**
 * In real situations singleton objects are related to resource consuming operations. That is why eager singleton pattern
 * isn't the best solution to use.
 * For purposes of optimization eager singleton pattern was introduced.
 */
public class LazySingleton {

    //Restricts object creation for outer code
    private LazySingleton(){}

    //Singleton
    private static LazySingleton instance;

    //Getter
    public static LazySingleton getINSTANCE() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
