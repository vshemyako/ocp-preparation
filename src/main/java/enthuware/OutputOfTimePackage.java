package enthuware;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * Just cuz I've forgotten how this package works
 */
public class OutputOfTimePackage {

    //Java docs claim this is the format: 2007-12-03T10:15:30.00Z
    private static void instantOutput() {
        //Possible to omit millis part
        try {
            Instant instant = Instant.parse("2000-12-01T12:00:00Z");
            System.out.println(instant);
        } catch (DateTimeParseException ex) {
            System.out.println(ex.getMessage());
        }

        //Format defined by Java docs
        try {
            Instant instant = Instant.parse("2000-12-01T12:00:00.555Z");
            System.out.println(instant);
        } catch (DateTimeParseException ex) {
            System.out.println(ex.getMessage());
        }

        //As expected - doesn't work
        try {
            Instant instant = Instant.parse("2000-12-01T12:00Z");
            System.out.println(instant);
        } catch (DateTimeParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //There's no method to convert Instant object to LocalDate
    private static void localDateOutput() {
        Instant instant = Instant.parse("2000-12-01T12:00:00Z");
        System.out.println(instant); //2000-12-01T12:00:00Z

        //ZoneId required
        ZoneId defaultZone = ZoneId.systemDefault(); //default is GMT+3

        //It's possible to convert instant to a DateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, defaultZone);
        System.out.println(dateTime); //2000-12-01T15:00

        //Instant -> ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, defaultZone);
        System.out.println(zonedDateTime); //2000-12-01T15:00+03:00[Europe/Moscow]

        //Behavior is the same as via Instant class
        LocalDateTime localDateTime = LocalDateTime.of(2018, 2, 10, 10, 0, 0);
        System.out.println(localDateTime); //2018-02-10T10:00

        //Behavior is the same as via Instant class
        ZonedDateTime zonedFromLocal = localDateTime.atZone(defaultZone);
        System.out.println(zonedFromLocal); //2018-02-10T10:00+03:00[Europe/Moscow]
    }

//Day-light savings: directly as an OCP objective
private static void dayLightSavings() {
    //Falls back on February 17 to 18 -> 23:00:00 GMT-2 + 1 hour -> 23:00:00 GMT-3
    //Springs forward on October 20 -> 23:00:00 GMT-3 + 1 hour -> 01:00:00 GMT-2
    ZoneId zone = ZoneId.of("America/Sao_Paulo");

    ZonedDateTime automn = ZonedDateTime.of(2018, 2, 17, 23, 0, 0, 0, zone);
    System.out.println(automn); //2018-02-17T23:00-02:00[America/Sao_Paulo]

    automn = automn.plus(1, ChronoUnit.HOURS);
    System.out.println(automn); //2018-02-17T23:00-03:00[America/Sao_Paulo]

    //What would you expect to get on February 17, 23:30:00?
    automn = ZonedDateTime.of(2018, 2, 17, 23, 30, 0, 0, zone); //2018-02-17T23:30-02:00[America/Sao_Paulo]
    System.out.println(automn);

    ZonedDateTime spring = ZonedDateTime.of(2018, 10, 20, 23, 0, 0, 0, zone);
    System.out.println(spring); //2018-10-20T23:00-03:00[America/Sao_Paulo]

    spring = spring.plus(1, ChronoUnit.HOURS);
    System.out.println(spring); //2018-10-21T01:00-02:00[America/Sao_Paulo]
}

    //Let's the fight begin
    public static void main(String... args) {
        //instantOutput();
        //localDateOutput();
        dayLightSavings();
    }
}
