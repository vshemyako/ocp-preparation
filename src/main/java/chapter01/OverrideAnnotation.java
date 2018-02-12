package chapter01;

/**
 * Use-case of using {@code @Override} annotation
 */
public class OverrideAnnotation {

}

class Human {
    public void walk() {
        System.out.println("Human is walking");
    }
}

class Man extends Human {

    //annotation can be applied only to a method, which is clearly stated by @Target annotation
    @Override
    public void walk() {
        System.out.println("Man is walking");
    }

    //if method does not actually override supertype method - compile time error occurs
    /*
    @Override
    public void walk(String name) {
        System.out.println(name.toUpperCase() + " is walking");
    }
    */
}
