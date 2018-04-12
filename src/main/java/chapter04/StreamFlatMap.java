package chapter04;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Reviewed usage of flatMap
 */
public class StreamFlatMap {

    //Stream<String[]> -> flatMap -> Stream<String>
    private static void flattenArray() {
        //one-dimension array isn't a problem
        String[] letters = new String[]{"a", "b", "c", "d", "e"};
        Stream<String> lettersStreamThroughHelper = Arrays.stream(letters);
        Stream<String> lettersStreamThroughStream = Stream.of(letters);

        lettersStreamThroughHelper.forEach(System.out::print);
        System.out.println();
        lettersStreamThroughStream.forEach(System.out::print);
        System.out.println();

        String[][] twoDimensionletters = new String[][]{{"a", "b"}, {"c", "d"}, {"e"}};
        Stream<String[]> twoDimensionlettersStream = Stream.of(twoDimensionletters);
        //trash is printed, we have to flatten it
        //twoDimensionlettersStream.forEach(System.out::print);

        //now it's ok!
        twoDimensionlettersStream.flatMap(Stream::of).forEach(System.out::print);
    }

    public static void main(String[] args) {
        flattenArray();
    }
}
