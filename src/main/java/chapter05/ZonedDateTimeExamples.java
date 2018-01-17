package chapter05;

import java.time.*;

/**
 * ZonedDateTime class wasn't on the OCA exam, so its better to pay extra attention to its methods
 */
public class ZonedDateTimeExamples {

    /**
     * Tests different signatures for ZonedDateTime objects creation
     */
    private static void createZonedDateTime() {
        //First its necessary to specify ZoneId object, cuz its required by all class signatures
        ZoneId zone = ZoneId.systemDefault();
        LocalDate date = LocalDate.of(2018, 1, 17);
        LocalTime time = LocalTime.of(22, 57);

        //date, time, zone
        ZonedDateTime dateAndTimeAndZone = ZonedDateTime.of(date, time, zone);
        System.out.println(dateAndTimeAndZone);

        //datetime, zone
        LocalDateTime dateTime = LocalDateTime.of(2018, 1, 17, 23, 0);
        ZonedDateTime dateTimeAndZone = ZonedDateTime.of(dateTime, zone);
        System.out.println(dateTimeAndZone);

        //cumbersome approach
        //year, month, day, hour, minute, second, nanos, zone
        ZonedDateTime doNotDoThis = ZonedDateTime.of(2018, 1, 17, 23, 3, 30, 150, zone);
        System.out.println(doNotDoThis);
    }

    public static void main(String[] args) {
        createZonedDateTime();
    }
}
