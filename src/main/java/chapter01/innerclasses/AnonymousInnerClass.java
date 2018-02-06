package chapter01.innerclasses;

/**
 * It's a local class which doesn't have a name: implements a method or extends a class
 */
public class AnonymousInnerClass {

    public static interface Machine {
        void drive();
    }

    public abstract class Motorcycle implements Machine {
        public abstract void drive();
    }

    public void rideMachine(Machine machine) {
        machine.drive();
    }

    public static void main(String[] args) {
        //creating an instance of interface type and passing it to a method
        AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass();

        //one may find it interesting: why it's possible to refer to an inner interface without an instance of the outer class
        //the answer is: inner interfaces are implicitly static
        anonymousInnerClass.rideMachine(new Machine() {
            @Override
            public void drive() {
                System.out.println("Wroom-wroom");
            }
        });

        //Remember that inner classes must be explicitly bounded with an instance of the outer class
        anonymousInnerClass.rideMachine(new AnonymousInnerClass().new Motorcycle() {
            @Override
            public void drive() {
                System.out.println("Woom-woom");
            }
        });
    }
}
