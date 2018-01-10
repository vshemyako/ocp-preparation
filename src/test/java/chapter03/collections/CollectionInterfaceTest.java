package chapter03.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Test cases upon methods of (@see java.util.Collection} interface.
 * Obviously it's impossible to test an interface itself, just its implementation.
 * In this case ArrayList will be used.
 */
public class CollectionInterfaceTest {

    private static final Collection<String> collection = new ArrayList<>();
    static {
        collection.add("first");
        collection.add("second");
        collection.add("third");
    }

    //  Query methods
    //  1. java.util.Collection#size()
    @Test
    public void sizeMethod() {
        Assert.assertEquals(3, collection.size());
    }

    //  2. java.util.Collection#isEmpty()
    @Test
    public void IsEmptyMethod() {
        Collection<Object> emptyCollection = Collections.EMPTY_LIST;
        Assert.assertTrue(emptyCollection.isEmpty());
    }

    //  3. java.util.Collection#contains()
    @Test
    public void containsMethod() {
        Assert.assertTrue(collection.contains("first"));
        Assert.assertFalse(collection.contains("fourth"));
    }

    // 4. java.util.Collection#toArray()
    @Test
    public void toArrayWithoutSpecifyingTypeMethod() {
        Assert.assertTrue(collection.toArray() instanceof Object[]);
    }

    // 5. java.util.Collection#toArray()
    @Test
    public void toArraySpecifyingTypeMethod() {
        Assert.assertTrue(collection.toArray(new String[0]) instanceof String[]);
    }

    //  Modification methods
    //  1. java.util.Collection#add()
    @Test
    public void addMethod() {
        Assert.assertFalse(collection.contains("fourth"));
        collection.add("fourth");
        Assert.assertTrue(collection.contains("fourth"));
    }

    //  2. java.util.Collection#remove()
    @Test
    public void removePassingObjectMethod() {
        Assert.assertTrue(collection.remove("fourth"));
        Assert.assertFalse(collection.remove("fourth"));
    }

    //  Bulk methods
    //  1. java.util.Collection#containsAll()
    @Test
    public void containsAllCollectionMethod() {
        //  the same order
        Collection<String> firstTillThirdStrings = Arrays.asList("first", "second", "third");
        Assert.assertTrue(collection.containsAll(firstTillThirdStrings));

        //  let's change the order
        firstTillThirdStrings = Arrays.asList("second", "first", "third");
        Assert.assertTrue(collection.containsAll(firstTillThirdStrings));

        //  let's add more elements
        firstTillThirdStrings = Arrays.asList("second", "first", "third", "second", "first", "third");
        Assert.assertTrue(collection.containsAll(firstTillThirdStrings));
    }

    //  2. java.util.Collection#retainAll()
    //  returns true only if the underlying collection was changed
    @Test
    public void retainAllCollectionMethod() {
        Collection<String> sourceCollection = new ArrayList<>();
        sourceCollection.add("first");
        sourceCollection.add("second");
        sourceCollection.add("third");

        Collection<String> targetCollection = new ArrayList<>();
        sourceCollection.add("third");

        //  removes everything leaving "third" string untouched
        Assert.assertTrue(sourceCollection.retainAll(targetCollection));

        //  doesn't change underlying collection
        Assert.assertFalse(sourceCollection.retainAll(targetCollection));
    }

    //  3. java.util.Collection#removeAll()
    //  remove collections' intersecting elements
    @Test
    public void removeAllCollectionMethod() {
        Collection<Integer> sourceCollection = new ArrayList<>();
        sourceCollection.add(10);
        sourceCollection.add(20);
        sourceCollection.add(30);
        sourceCollection.add(40);

        Collection<Integer> targetCollection = new ArrayList<>();
        targetCollection.add(10);
        targetCollection.add(20);
        targetCollection.add(50);

        sourceCollection.removeAll(targetCollection);
        Assert.assertFalse(sourceCollection.contains(10));
        Assert.assertFalse(sourceCollection.contains(20));
        Assert.assertTrue(sourceCollection.contains(30));
        Assert.assertTrue(sourceCollection.contains(40));
        Assert.assertFalse(sourceCollection.contains(50));
    }

    //  4. java.util.Collection#addAll()
    @Test
    public void addAllCollectionMethod() {
        Collection<Integer> sourceCollection = new ArrayList<>();
        sourceCollection.add(10);
        sourceCollection.add(20);

        Assert.assertTrue(sourceCollection.contains(10));
        Assert.assertTrue(sourceCollection.contains(20));
        Assert.assertFalse(sourceCollection.contains(30));
        Assert.assertFalse(sourceCollection.contains(40));

        Collection<Integer> targetCollection = new ArrayList<>();
        targetCollection.add(30);
        targetCollection.add(40);

        sourceCollection.addAll(targetCollection);

        Assert.assertTrue(sourceCollection.contains(10));
        Assert.assertTrue(sourceCollection.contains(20));
        Assert.assertTrue(sourceCollection.contains(30));
        Assert.assertTrue(sourceCollection.contains(40));
    }

    //  5. java.util.Collection#clear()
    @Test
    public void clearCollectionMethod() {
        Collection<Integer> sourceCollection = new ArrayList<>();
        sourceCollection.add(10);
        sourceCollection.add(20);
        Assert.assertFalse(sourceCollection.isEmpty());

        sourceCollection.clear();
        Assert.assertTrue(sourceCollection.isEmpty());
    }

    //  6. java.util.Collection#removeIf()
    @Test
    public void removeIfConditionEvaluatesToTrueMethod() {
        Collection<Integer> sourceCollection = new ArrayList<>();
        sourceCollection.add(10);
        sourceCollection.add(11);
        sourceCollection.add(12);
        sourceCollection.add(13);

        //  power of lambda expressions
        Predicate<Integer> filterOddNumbers = number -> number % 2 == 1;
        sourceCollection.removeIf(filterOddNumbers);

        Assert.assertTrue(sourceCollection.contains(10));
        Assert.assertTrue(sourceCollection.contains(12));

        Assert.assertFalse(sourceCollection.contains(11));
        Assert.assertFalse(sourceCollection.contains(13));
    }

    //  Streams
    //  1. java.util.Collection#stream()
    @Test
    public void convertToStreamMethod() {
        Collection<Number> numbers = Collections.EMPTY_LIST;
        Assert.assertTrue(numbers.stream() instanceof Stream);
    }


    //  2. java.util.Collection#parallelStream()
    @Test
    public void convertToParallelStreamMethod() {

        Collection<Number> numbers = Collections.EMPTY_LIST;
        Assert.assertTrue(numbers.parallelStream() instanceof Stream);
    }
}
