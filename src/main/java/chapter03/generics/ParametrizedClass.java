package chapter03.generics;

/**
 * JDK1.5 offered mechanism which allows to write extremely flexible code
 */
public class ParametrizedClass<T, U, V> {

    //no concrete type information
    private T firstTypeObject;
    private U secondTypeObject;
    private V thirdTypeObject;

    public ParametrizedClass(T firstTypeObject, U secondTypeObject, V thirdTypeObject) {
        this.firstTypeObject = firstTypeObject;
        this.secondTypeObject = secondTypeObject;
        this.thirdTypeObject = thirdTypeObject;
    }

    public T getFirstTypeObject() {
        return firstTypeObject;
    }

    public U getSecondTypeObject() {
        return secondTypeObject;
    }

    public V getThirdTypeObject() {
        return thirdTypeObject;
    }
}

class ParametrizedClassTest {
    public static void main(String[] args) {
        //A thing to remember: generics are actually a syntax sugar which is substituted with Object type after compilation
        //Reason - prior to JDK1.5 code backward compatibility
        ParametrizedClass<Integer, Integer, Integer> obj = new ParametrizedClass<>(1, 2, 3);
        System.out.println(obj.getFirstTypeObject());
        System.out.println(obj.getSecondTypeObject());
        System.out.println(obj.getThirdTypeObject());
    }
}
