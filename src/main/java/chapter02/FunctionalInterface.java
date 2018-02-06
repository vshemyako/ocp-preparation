package chapter02;

/**
 * JDK 1.8 introduced convenient annotation {@code @FunctionalInterface} which prevents interfaces
 * from containing more than one abstract method
 */
@FunctionalInterface
interface Interface {
    long functionMeasurement();
}

class TestFunctionalInterface {

    static boolean testFunction(Interface anInterface) {
        long functionPower = 100L;
        return anInterface.functionMeasurement() > functionPower;
    }

    public static void main(String[] args) {
        //the simplest way
        System.out.println(testFunction(() -> 20L));

        //another approach
        Interface anInterface = () -> 150L;
        System.out.println(testFunction(anInterface));
    }
}