package chapter05;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Date/Time objects are immutable, so you have to assign newly created object to a variable after manipulations were
 * applied
 */
public class DateAndTimeManipulation {

    /**
     * Shows manipulation operations with date/time objects.
     * Note: its possible to subtract the same fields using minus* methods.
     * Note: DateTime/ZonedDateTime objects can be manipulated using a combination of any methods mentioned below
     */
    private static void manipulateDateOrTimeObjects() {
        LocalDate date = LocalDate.now();
        date = date.plusDays(1);
        //better approach than plusDays(7)
        date = date.plusWeeks(1);
        date = date.plusMonths(1);
        date = date.plusYears(1);
        System.out.println(date);

        LocalTime time = LocalTime.now();
        time = time.plusNanos(1);
        time = time.plusSeconds(1);
        time = time.plusMinutes(1);
        time = time.plusHours(1);
        System.out.println(time);
    }

    public static void main(String[] args) {
        manipulateDateOrTimeObjects();
    }
}
