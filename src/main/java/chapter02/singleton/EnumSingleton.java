package chapter02.singleton;

/**
 * All of the singleton patterns can be destroyed with powerful java mechanism which is called 'Reflection'.
 * Smart guy whose name is Joshua Bloch suggests to use Enum to implement singleton pattern. Of course it doesn't allow
 * lazy instantiation which is a flaw.
 */
public enum EnumSingleton {

    //Singleton
    //treated as public static final
    INSTANCE;

    //some logic goes here
}
