package chapter06;

/**
 * It's possible to create objects in a try clause which implement {@link java.lang.AutoCloseable} interface
 */
public class UsageOfAutocloseable {

    public static void main(String[] args) {

        //Usage example
        //Note: object is close right after 'try' block
        try (Box box = new Box()) {
            System.out.println("Try block");
        } catch (Exception ex) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally block");
        }
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
