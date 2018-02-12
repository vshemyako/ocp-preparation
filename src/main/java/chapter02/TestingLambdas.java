package chapter02;

/**
 * Note: if you specify a parameter list it's important to be consistent with parameter types:
 * - you define all types of all of the parameters
 * - you define none types
 */
public class TestingLambdas {
    public static void main(String[] args) {
        FirstTest firstTest = (first, second) -> {
            //it's impossible to redeclare local variable
            //String first = "Illegal";
            System.out.println(first + second);
        };
    }
}

interface FirstTest {
    void firstTest(String first, String second);
}
