package chapter10;

import java.sql.*;

/**
 * Demonstrates different types of {@link java.sql.Statement} as well as DML queries
 */
public class SelectQueries {

    private static final String DB_URL = "jdbc:derby:zoo";
    private static final String SPECIES_ID = "id";
    private static final String SPECIES_NAME = "name";
    private static final String ANIMAL_DATE_BORN = "date_born";

    /**
     * Executes sql query. Only DML queries are supported, type forward only
     */
    private void executeDML(String dmlString) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            Statement sqlStatement = connection.createStatement();
            ResultSet resultSet = sqlStatement.executeQuery(dmlString);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(SPECIES_ID) + " " + resultSet.getString(SPECIES_NAME));
            }
        } catch (SQLException e) {
            System.err.println("Sql exception: " + e.getMessage());
        }
    }

    /**
     * Shows the difference between different sql date objects
     */
    private void retrieveDateObjects(String dmlString) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            Statement sqlStatement = connection.createStatement();
            ResultSet resultSet = sqlStatement.executeQuery(dmlString);
            while (resultSet.next()) {
                java.sql.Date noTimePart = resultSet.getDate(ANIMAL_DATE_BORN);
                java.sql.Time noDayPart = resultSet.getTime(ANIMAL_DATE_BORN);
                java.sql.Timestamp dayTimePart = resultSet.getTimestamp(ANIMAL_DATE_BORN);

                System.out.println("Day: " + noTimePart.toLocalDate());
                System.out.println("Time: " + noDayPart.toLocalTime());
                System.out.println("Day-time: " + dayTimePart.toLocalDateTime());
            }
        } catch (SQLException e) {
            System.err.println("Sql exception: " + e.getMessage());
        }
    }

    /**
     * Plain old entry point
     */
    public static void main(String[] args) {
        String sqlQuery = "SELECT * FROM SPECIES";
        new SelectQueries().executeDML(sqlQuery);

        String anotherSqlQuery = "SELECT date_born FROM animal WHERE name = 'Zelda'";
        new SelectQueries().retrieveDateObjects(anotherSqlQuery);
    }
}
