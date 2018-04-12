package chapter06;

/**
 * It's possible to create objects in a try clause which implement {@link java.lang.AutoCloseable} interface
 */
public class UsageOfAutocloseable {

    public static void main(String[] args) {

        //Usage example
        //Note: object is close right after 'try' block
        try (Box box = new Box(); Box box2 = new Box();) {
            System.out.println("Try block");
        } catch (Exception ex) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally block");
        }
    }

    //Maybe not so obvious scope topic of a try-with-resources clause
    private static void scope() throws Exception {
        //One have to declare and initialize variables in try-with-resources clause
        /*Box box2 = null;
        try (Box box = new Box();
             box2 =new Box() ;){
            //variables declared in try-with-resources clause are effectively final
            box = new Box();
            System.out.println("Try block");
        }*/
    }
}

/**
 * An example of autocloseable class
 */
class Box implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("The box is closed.");
    }
}
