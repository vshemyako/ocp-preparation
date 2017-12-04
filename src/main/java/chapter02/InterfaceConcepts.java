package chapter02;

/**
 * One have to be familiar with interfaces in order to learn functional java programming
 */
public class InterfaceConcepts {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.howFastAreYou();
    }
}

interface Fly {
    int speed = 100;
}

class Bird implements Fly {
    public void howFastAreYou() {
        System.out.format("Flying with %s kilometers per hour", speed);
    }
}
