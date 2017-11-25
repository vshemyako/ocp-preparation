package chapter01;

/**
 * Methods are called virtual if they are not private, not static and not final
 * This simply applies to methods that may be overridden
 */
public class VirtualMethods {
    public static void main(String[] args) {
        Annie annieOrNot = new Sanchez();

        //remember: JVM always looks for overridden methods, even if the are called from not overridden one
        annieOrNot.expressThoughts();
    }
}

class Annie {
    public void expressThoughts() {
        speak();
    }

    public void speak() {
        System.out.println("Annie speaks");
    }
}

class Sanchez extends Annie {
    public void speak() {
        System.out.println("Sanchez speaks");
    }
}
