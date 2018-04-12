package enthuware;

import java.time.Duration;
import java.time.Period;

/**
 * Though answered correctly, wasn't sure
 */
public class OutputOfPeriodsAndDurations {

    /**
     * Max output is in hours, min output is in seconds
     */
private static void outputDuration() {
    //1 day duration is straightforward
    Duration d = Duration.ofDays(1);
    System.out.println(d); //PT24H

    //50 days? or 1 month 20 days?
    d = Duration.ofDays(50);
    System.out.println(d); //PT1200H

    //0 days?
    d = Duration.ofDays(0);
    System.out.println(d); //PT0S

    //0 hours?
    d = Duration.ofHours(0);
    System.out.println(d); //PT0S

    //0 minutes?
    d = Duration.ofMinutes(0);
    System.out.println(d); //PT0S

    //150 minutes? or 2 hours and 30 minutes?
    d = Duration.ofMinutes(150); //PT2H30M
    System.out.println(d);
}

private static void outputPeriod() {
    //1 year Period is straightforward
    Period p = Period.ofYears(1);
    System.out.println(p); //P1Y

    //20 month? or 1 year and 8 month?
    p = Period.ofMonths(20);
    System.out.println(p); //P20M -> doesn't wrap!!!

    //Weeks?
    p = Period.ofWeeks(10);
    System.out.println(p); //P70D -> doesn't wrap!!!

    //0 years?
    p = Period.ofYears(0);
    System.out.println(p); //P0D

    //0 days?
    p = Period.ofDays(0);
    System.out.println(p); //P0D
}

    /**
     * Rock'n'roll
     */
    public static void main(String[] args) {
        //outputDuration();
        outputPeriod();
    }
}
