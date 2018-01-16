package chapter04;

import java.util.stream.IntStream;

/**
 * OCP exam requires knowledge of IntStream, LongStream and DoubleStream
 */
public class WorkingWithPrimitiveStreams {

    /**
     * Lists the ways to create primitive streams
     */
    public static void primitiveStreamCreation() {
        IntStream oneIntStream = IntStream.of(1);
        IntStream fewIntsStream = IntStream.of(1, 3, 5, 7, 9);

        //It's also possible to generate a stream of primitives
        IntStream generatedIntStream = IntStream.generate(() -> (int) (Math.random() * 10));
        generatedIntStream.limit(5).forEach(System.out::print);

        //Primitive streams offer more convenient methods for stream generating
        //'6' isn't included
        IntStream rangeNumbers = IntStream.range(1, 6);
        //inclusive range
        IntStream inclusiveRangeNumbers = IntStream.rangeClosed(1, 6);

        System.out.println();
        rangeNumbers.forEach(System.out::print);
        System.out.println();
        inclusiveRangeNumbers.forEach(System.out::print);
    }

    /**
     * Tests chosen method
     */
    public static void main(String[] args) {
        primitiveStreamCreation();
    }
}
