package chapter01;

/**
 * Knowledge of enums is required for OCPJP
 */
public class Enum {
    public static void main(String[] args) {

        //it's possible to retrieve an array of enum values
        //actually rather strange method because there is no corresponding code for it in java.lang.Enum
        for (Season season : Season.values()) {
            System.out.println(season);
        }

        //though it's impossible to see real code for 'values()' method it indeed returns an array
        Season[] array = Season.values();

        System.out.println("Implicit toString() invocation: " + Season.SUMMER);
        System.out.println("Explicit name() invocation: " + Season.AUTUMN.name());

        //one doesn't have to invoke ordinal method: it's used for specific enumSet and enumMap data structures
        System.out.println("Explicit ordinal() invocation: " + Season.WINTER.ordinal());

        //get a enum constant from a string
        System.out.println(Season.valueOf("SPRING"));
        System.out.println(java.lang.Enum.valueOf(Season.class, "SUMMER"));

        try {
            Season.valueOf("Winter");
        } catch (IllegalArgumentException exc) {
            System.out.println("Case sensitive comparison is used");
        }

        if (Season.SPRING != Season.WINTER) {
            System.out.println("Comparison using operators");
        }

        Season unknownSeason = Season.AUTUMN;
        switch (unknownSeason) {
            case AUTUMN: {
                System.out.println("It's an autumn.");
            }
            //you cannot use qualified name
            //case Season.WINTER:
        }
    }
}

/**
 * Behind the scenes enum is a class with a bunch of final static fields
 */
enum Season {
    SUMMER, AUTUMN, WINTER, SPRING
}
