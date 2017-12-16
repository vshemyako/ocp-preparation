package chapter03.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;

/**
 * Test cases upon methods of {@see java.util.Iterable} interface
 */
public class IterableInterfaceTest {

    Iterable<String> iterable = Arrays.asList("first", "second", "third");

    //  1. java.util.Iterable#iterator()
    @Test
    public void getIterator() {
        Assert.assertTrue(iterable.iterator() instanceof Iterator);
    }

    // 2. java.util.Iterable#spliterator()
    @Test
    public void getSpliterator() {
        Assert.assertTrue(iterable.spliterator() instanceof Spliterator);
    }

    // 3. java.util.Iterable#forEach()
    @Test
    public void isEachElementProcessed() {
        final String THREE_DOLLAR_BILL = "ThreeDollarBill";

        //Substitute each element with a new String object
        iterable.forEach(element -> {
            Assert.assertNotEquals(THREE_DOLLAR_BILL, element);
            element = THREE_DOLLAR_BILL;
            Assert.assertEquals(THREE_DOLLAR_BILL, element);});
    }
}
