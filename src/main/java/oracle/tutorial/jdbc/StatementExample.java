package oracle.tutorial.jdbc;

import java.sql.*;

/**
 * JDBC review class
 */
public class StatementExample {

    private static final String JDBC_URL = "jdbc:derby:zoo";

    /**
     * Demonstrates different patterns to use for a {@link java.sql.Statement} type objects
     */
    private static void execute() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement()) {
            boolean isResultSet = statement.execute("SELECT * FROM species");
            if (isResultSet) {
                ResultSet resultSet = statement.getResultSet();
                System.out.println(resultSet.next());
                System.out.println(resultSet.next());

                //As we see subsequent calls to the #next method after it has return {@code false} doesn't produce exception
                System.out.println(resultSet.next());
                System.out.println(resultSet.next());

                //remember only #next() is valid for ResultSet.TYPE_FORWARD_ONLY
                //System.out.println(resultSet.first());
            } else {
                int affectedRows = statement.getUpdateCount();
            }
        } catch (SQLException e) {
            System.out.println("Exception was thrown: " + e.getMessage());
        }
    }

    /**
     * Scrolls to the desired absolute or relative position
     */
    private static void scroll() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM species");

            //As you may see this doesn't produce an exception
            System.out.println(resultSet.absolute(1000));
            System.out.println(resultSet.absolute(-1000));

            System.out.println(resultSet.relative(-1000));
            System.out.println(resultSet.relative(2000));
        } catch (SQLException e) {
            System.out.println("Exception was thrown: " + e.getMessage());
        }
    }

    /**
     * Entry point
     */
    public static void main(String[] args) {
        //execute();
        scroll();
    }
}
