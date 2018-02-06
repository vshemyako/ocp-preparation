package chapter01.innerclasses;

/**
 * Inner classes which are declared within another class without 'static' keyword
 */
public class InnerClassAccessModifiers {

    //inner class can be private, package-private, protected, public
    public class FirstInnerClass {
    }

    protected class SecondInnerClass {
    }

    class ThirdInnerClass {
    }

    private class ForthInnerClass {
    }

    //the same for interfaces
    public interface FirstInnerInterface {
    }

    protected interface SecondInnerInterface {
    }

    interface ThirdInnerInterface {
    }

    private interface ForthInnerInterface {
    }
}
