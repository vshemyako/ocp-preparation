package enthuware;

import java.io.Serializable;

/**
 * Inheritance chain may be tricky
 */
public class OnceAgainInheritance {

    private static void interfaceAndClassTail() {
        Serializable instance = new Box();
        //It's ok cuz some subclasses of Circle may implement Serializable
        noName((Circle) instance);
        //There's no way that a box could be a circle
        //noName((Circle) new Box());
        //The same with instanceof
        System.out.println(instance instanceof Circle);
    }

    private static void noName(Circle circle) {
        System.out.println("Done");
    }

    //Dummy class for tests
    private static class Box implements Serializable {
    }

    private static class Circle {
    }
}
