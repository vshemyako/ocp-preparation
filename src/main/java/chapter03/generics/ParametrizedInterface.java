package chapter03.generics;

/**
 * Declaring generic interface is the same as declaring a class
 */
public interface ParametrizedInterface<T> {
    void mutate(T t);
}

//What really differs - it's possibilities to implement generic interface
//No type information
class FirstGenericClass implements ParametrizedInterface {
    @Override
    public void mutate(Object o) {
    }
}

//Create concrete generic class
class SecondGenericClass<T> implements ParametrizedInterface<T> {
    @Override
    public void mutate(T t) {
    }
}

//Type specified
class ThirdGenericClass implements ParametrizedInterface<StringBuilder> {
    @Override
    public void mutate(StringBuilder stringBuilder) {
    }
}


