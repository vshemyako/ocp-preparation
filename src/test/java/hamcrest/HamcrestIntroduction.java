package hamcrest;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsCollectionWithSize;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * I've came to an idea that the best way to learn java API is to write tests upon them.
 * But the problem is, that I don't really know how to write these tests (LMFAO).
 * The goal is to write several tutorial to get my hands dirty.
 */
public class HamcrestIntroduction {

    //  Let's create several List objects
    private static final List<Integer> oneToFive = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> fromOneTillFive = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> fromFiveTillOne = Arrays.asList(5, 4, 3, 2, 1);
    private static final List<Integer> threeToSeven = Arrays.asList(3, 4, 5, 6, 7);

    //  1. Test lists equality
    @Test
    public void collectionEquality() {
        MatcherAssert.assertThat(oneToFive, CoreMatchers.is(fromOneTillFive));
    }

    //  2. Checks whether those lists contain a number
    @Test
    public void elementPossession() {
        MatcherAssert.assertThat(oneToFive, CoreMatchers.hasItem(3));
        MatcherAssert.assertThat(fromOneTillFive, CoreMatchers.hasItem(3));
        MatcherAssert.assertThat(fromFiveTillOne, CoreMatchers.hasItem(3));
        MatcherAssert.assertThat(threeToSeven, CoreMatchers.hasItem(3));
    }

    //  3. Checks whether those lists are of specified size
    @Test
    public void listSize() {
        //Let's invoke size() method
        MatcherAssert.assertThat(oneToFive, IsCollectionWithSize.hasSize(oneToFive.size()));
        MatcherAssert.assertThat(fromOneTillFive, IsCollectionWithSize.hasSize(fromOneTillFive.size()));
        MatcherAssert.assertThat(fromFiveTillOne, IsCollectionWithSize.hasSize(fromFiveTillOne.size()));
        MatcherAssert.assertThat(threeToSeven, IsCollectionWithSize.hasSize(threeToSeven.size()));
    }

    //  4. Checks whether specified lists contain the same elements
    @Test
    public void containsAll() {
        MatcherAssert.assertThat(oneToFive, IsIterableContainingInOrder.contains(1, 2, 3, 4, 5));
        MatcherAssert.assertThat(fromOneTillFive, IsIterableContainingInOrder.contains(1, 2, 3, 4, 5));
        MatcherAssert.assertThat(fromFiveTillOne, IsIterableContainingInAnyOrder.containsInAnyOrder(1, 2, 3, 4, 5));
        MatcherAssert.assertThat(threeToSeven, IsIterableContainingInOrder.contains(3, 4, 5, 6, 7));
    }
}
