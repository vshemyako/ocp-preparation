package chapter03.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Set interface places additional stipulations on the add method
 */
public class SetInterfaceTest {

    //  1. java.util.Set#add()
    @Test
    public void addDuplicateElement() {
        Set<Integer> numbers = new HashSet<>();

        Assert.assertTrue(numbers.add(10));
        Assert.assertTrue(numbers.add(20));

        //set doesn't allow duplicates
        Assert.assertFalse(numbers.add(20));
    }
}
