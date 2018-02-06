package chapter05;

/**
 * Encountered an example result of which seems strange to me
 */
public class StringBuilderRevision {

    /**
     * Demonstration of example itself
     */
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("abcde");
        stringBuilder.insert(1, '-').delete(3, 4); //a-bcde //a-bde
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.substring(2, 4)); //bd
    }
}
