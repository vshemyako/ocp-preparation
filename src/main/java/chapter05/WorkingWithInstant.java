package chapter05;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 * Instant represents specific moment in time in GMT time zone which is very handy
 */
public class WorkingWithInstant {

    /**
     * Shows basic usage of Instant objects
     */
    private static void instantTest() {
        Instant now = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred while sleeping");
        }
        Instant then = Instant.now();

        //Exactly one second has left
        System.out.println(now);
        System.out.println(then);

        //Counts the period
        System.out.println("Number of seconds between: " + Duration.between(now, then).getSeconds());

        //It's possible to change Instant
        Instant plusHours = then.plus(1, ChronoUnit.HOURS);
        System.out.println(plusHours);

        //Remember though instant can actually represent any moment in time its impossible to manipulate it using
        //weeks, month, years and so on
        try {
            Instant plusDays = then.plus(10, ChronoUnit.WEEKS);
            System.out.println(plusDays);
        } catch (UnsupportedTemporalTypeException ex) {
            System.out.println("Don't pass weeks, months, years...");
        }
    }

    private static void instantToLocalDateTime() {
        Instant instant = Instant.parse("2018-03-29T20:00:00Z");
        System.out.println(instant);

        ZoneId systemDefault = ZoneId.systemDefault();
        System.out.println(systemDefault);

        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, systemDefault);
        System.out.println(dateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, systemDefault);
        System.out.println(zonedDateTime);
    }

    public static void main(String[] args) {
        instantToLocalDateTime();
    }
}
