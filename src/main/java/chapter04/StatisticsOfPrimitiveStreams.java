package chapter04;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 * Each primitive stream can return statistics about itself
 */
public class StatisticsOfPrimitiveStreams {

    /**
     * Show basic usage of {@link java.util.IntSummaryStatistics} class
     */
    public static void examineStatisticFunctionality() {

        IntStream numbers = IntStream.rangeClosed(10, 25);
        IntSummaryStatistics statistics = numbers.summaryStatistics();

        //return min value
        System.out.println(statistics.getMin());

        //return max value
        System.out.println(statistics.getMax());

        //return average
        System.out.println(statistics.getAverage());

        //count elements
        System.out.println(statistics.getCount());
    }

    /**
     * For testing purposes
     */
    public static void main(String[] args) {
        examineStatisticFunctionality();
    }
}
