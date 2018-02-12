package chapter01.innerclasses;

/**
 * Inner class can extend and implement any class or interface
 * Final and abstract keywords can be applied
 * It's even possible to extend outer class within which inner is declared
 *
 * Remember: it's not allowed for an outer class to extend or implement inner members
 */
public class InnerClassInheritance {

    //really strange but possible
    private abstract class FirstInnerClass extends InnerClassInheritance {
    }

    private final class SecondInnerClass extends FirstInnerClass implements SecondInnerInterface {
    }

    private interface FirstInnerInterface extends SecondInnerInterface {
    }

    private interface SecondInnerInterface {
    }
}

//Cyclic inheritance error
/*
class DontDoThat extends DontDoThat.InnerClass{
    class InnerClass {}
}
*/
