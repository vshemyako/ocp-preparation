package generics;

/**
 * No every type is allowed to have a type parameter. Here's a list:
 * - Anonymous classes - they do not have a name
 * - Enum classes - they are 'static' in nature, no it doesn't have sense
 * - Exception types - exception handling mechanism is a runtime mechanism, generics is a compile time mechanism
 */
public class TypesWithNoTypeParameters {

    /*
    public enum Season<E> {
        WINTER, SPRING, SUMMER, AUTUMN;
    }
    */

    /*
    public static class TypeException<E> extends Throwable {
    }
    */
}
