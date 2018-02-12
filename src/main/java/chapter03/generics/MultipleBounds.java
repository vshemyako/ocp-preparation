package chapter03.generics;

/**
 * It turns out that it's possible to declare multiple bounds of a parameterized type
 */
public class MultipleBounds {

    public static class A {}
    public interface B {}
    public interface C {}

    //insane syntax
    public class GenericClass<E extends A & B & C> {}

    //if there are multiple bounds one of which is a class, it should be declared first!
    //public class IllegalGenericClass<E extends B & A & C> {}
}
