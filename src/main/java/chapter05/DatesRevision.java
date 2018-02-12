package chapter05;

import java.time.*;

/**
 * OCP goes a little bit further in requirements of knowledge of java.time package
 */
public class DatesRevision {

    /**
     * Prints out date/time objects
     */
    private static void currentDateCreation() {
        System.out.println("Get current date objects:");
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
    }

    /**
     * Day/month starts from '1'
     */
    private static void createLocalDate() {
        System.out.println("Different local date factory methods:");
        System.out.println(LocalDate.of(2018, 1, 17));
        System.out.println(LocalDate.of(2018, Month.JANUARY, 17));
    }

    /**
     * Demonstrates different methods signatures of LocalTime
     */
    private static void createLocalTime() {
        System.out.println("Different local time factory methods:");
        System.out.println(LocalTime.of(23, 59));
        System.out.println(LocalTime.of(23, 59, 59));
        System.out.println(LocalTime.of(23, 59, 59, 999999999));
    }

    /**
     * LocalDateTime class offers all possible combinations of LocalDate/LocalTime factory methods
     */
    private static void createLocalDateTime() {
        System.out.println("Different local date time factory methods:");
        LocalDate date = LocalDate.of(2018, 1, 17);
        LocalTime time = LocalTime.of(22, 39);
        System.out.println(LocalDateTime.of(date, time));

        System.out.println(LocalDateTime.of(2018, 1, 17, 22, 40));
    }

    /**
     * Runs desired method
     */
    public static void main(String[] args) {
        //currentDateCreation();
        //createLocalDate();
        //createLocalTime();
        createLocalDateTime();
    }
}
