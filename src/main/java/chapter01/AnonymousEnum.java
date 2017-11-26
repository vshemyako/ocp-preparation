package chapter01;

/**
 * It's possible to type enum constructs which resemble anonymous classes
 */
public class AnonymousEnum {
    public static void main(String[] args) {
        Cat desiredCat = Cat.Busia;
        desiredCat.speak();
    }
}

enum Cat {
    //really strange, but possible
    Lialia {
        public void speak() {
            System.out.println("I'm Lialia");
        }
    },
    Busia {
        public void speak() {
            System.out.println("I'm Busia");
        }
    };

    //methods within enum constant will be accessible only if such method is declared in a enum class
    public abstract void speak();
}
