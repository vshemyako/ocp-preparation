package chapter05;

import java.time.*;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 * Its possible to manipulate LocalDate/LocalDateTime/ZonedDateTime objects using Period class. Objects of class Period
 * contain information about:
 * - years
 * - months
 * - days
 */
public class WorkingWithPeriods {

    /**
     * Basic usage of Period instances
     */
    public static void manipulateDates() {
        Period years = Period.ofYears(1);
        System.out.println(years);

        Period months = Period.ofMonths(1);
        System.out.println(months);

        Period weeks = Period.ofWeeks(1);
        System.out.println(weeks);

        Period days = Period.ofDays(1);
        System.out.println(days);

        Period combinations = Period.of(1, 1, 1);
        System.out.println(combinations);

        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println("Manipulating LocalDate object: ");
        System.out.println(date.plus(years));
        System.out.println(date.plus(months));
        System.out.println(date.plus(weeks));
        System.out.println(date.plus(days));
        System.out.println();

        System.out.println("Manipulating LocalDateTime object: ");
        System.out.println(localDateTime.plus(years));
        System.out.println(localDateTime.plus(months));
        System.out.println(localDateTime.plus(weeks));
        System.out.println(localDateTime.plus(days));
        System.out.println();

        System.out.println("Manipulating ZonedDateTime object: ");
        System.out.println(zonedDateTime.plus(years));
        System.out.println(zonedDateTime.plus(months));
        System.out.println(zonedDateTime.plus(weeks));
        System.out.println(zonedDateTime.plus(days));
        System.out.println();

        //LocalTime object doesn't contain 'date' part so its impossible to change it using periods
        try {
            time.plus(years);
        } catch (UnsupportedTemporalTypeException ex) {
            System.out.format("No date part, impossible to add. %s", ex.getMessage());
        }
    }

    public static void main(String[] args) {
        manipulateDates();
    }
}
