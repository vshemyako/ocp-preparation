package chapter06;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * Examples of some edge cases which I've encountered resolving dummy OCP tests
 */
public class TryCatchBlockTests {

    private static class SneezeException extends Exception {
    }

    private static class SniffleException extends SneezeException {
    }

    public static void main(String[] args) throws SneezeException {
        try {
            throw new SneezeException();
        } catch (Exception e) {
            // e = new RuntimeException();
            throw e;
        }
    }

    /**
     * Pay attention, java figures out, that no another type than SQL exception can be thrown here
     */
    public void read() throws SQLException {
        try {
            readFromDatabase();
        } catch (Exception e) {
            throw e;
        }
    }

    private void readFromDatabase() throws SQLException {
    }

    private static void functionalTest() {
        //Supplier<WithException> withException = WithException::fallWithDefaultError;
    }
}

interface WithException {
    void fallWithError() throws Exception;

    static WithException fallWithDefaultError() throws Exception {
        throw new Exception();
    }
}
