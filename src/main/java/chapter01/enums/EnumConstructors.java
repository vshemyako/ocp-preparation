package chapter01.enums;

/**
 * Enum is a variation of class with bunch of special restrictions
 */
public class EnumConstructors {
    public static void main(String[] args) {
        Planet pluto = Planet.Pluto;
        Planet mars = Planet.Mars;
    }
}

enum Planet {
    // ';' - semicolon is optional when a list of enum values is declared
    Pluto("pluto"), Mars("mars"), Earth("earth");

    public String name;
    public static String greeting;

    {
        name = "Have no idea";
        System.out.println("IIB invocation");

        //static field cannot be assigned from non-static block!
        //this.greeting = "Illegal";
    }

    //really strange thing going on here: static block is invoked LAST!
    //possible reason: enum is treated as a constant
    static {
        System.out.println("Static block in enum class");
        greeting = "Hello";
    }

    //Constructor is invoked only once for all of the instances
    Planet(String name) {
        System.out.println("Planet constructor");
        this.name = name;

        //another strange thing: static field cannot be referenced from within a constructor
        //this.greeting = "Goodbye";
    }

    public void setName(String name) {
        this.name = name;
    }
}

enum Clothes {
    // if something comes after declaration ';' semicolon is mandatory
    Nike, Adidas, Puma;

    private Clothes() {
        this("don't have to do this");
        System.out.println("Constructor invocation");
    }

    //private modifier is the only one which can be used with constructor and is implied (therefore can be omitted)
    Clothes(String name) {
        System.out.println("Constructor overload");
    }

    //compile error
    /*
    public Clothes(Integer illegalConstructor) {
    }
    */
}
