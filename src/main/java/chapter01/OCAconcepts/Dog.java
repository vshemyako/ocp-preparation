package chapter01.OCAconcepts;

/**
 * Some overriding concepts
 */
public class Dog {
    public static void bark() {
        System.out.println("Bark!");
    }
}

// Have read wrong that static keyword can be applied independently to method being overridden
class LittleGod extends Dog {
    public static void bark() {
        System.out.println("Bark!");
    }
}
