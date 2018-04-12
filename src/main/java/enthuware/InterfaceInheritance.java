package enthuware;

/**
 * Sometimes I've come across some examples which are not straightforward
 */
public class InterfaceInheritance implements Vaporizer {

    private void invokeSuper() {
        //ladies and gentlemen: what the hell is this?
        Vaporizer.super.vaporize();
    }

    public void boil() {
        System.out.println("Boiling...");
    }

    public static void main(String[] args) {
        //Vaporizer v = new Reactor(); //2
        //v.vaporize(); //3
        //Boiler.shutdown(); //4

        new InterfaceInheritance().invokeSuper();
    }
}

interface Boiler {
    void boil();

    static void shutdown() {
        System.out.println("shutting down");
    }
}

interface Vaporizer extends Boiler {  //1
    default void vaporize() {
        boil();
        System.out.println("Vaporized!");
    }
}
