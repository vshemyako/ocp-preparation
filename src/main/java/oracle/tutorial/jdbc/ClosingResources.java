package oracle.tutorial.jdbc;

import java.sql.*;

/**
 * Tutorials claim that JDBC resources have to be closed in the right order. Tried to imitate situation when those
 * suggestion isn't followed
 */
public class ClosingResources {

    private static final String JDBC_URL = "jdbc:derby:zoo";

    /**
     * Closes JDBC resources in the wrong order
     */
    private static void close() {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");

            //intentionally closing in the wrong order
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    /**
     * Invokes private methods
     */
    public static void main(String[] args) {
        close();
    }
}
