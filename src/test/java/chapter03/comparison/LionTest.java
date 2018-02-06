package chapter03.comparison;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests {@see java.lang.Comparison} implementation by 'Lion' class
 */
public class LionTest {

    @Test
    public void comparisonTest() {
        Lion tenTeethLion = new Lion(10, "Simba");
        Lion twentyTeethLion = new Lion(20, "Scar");
        Lion uknownLion = new Lion(15, "Mufasa");
        Lion prairieLion = new Lion(15, "Jiamsu");

        Assert.assertTrue(tenTeethLion.compareTo(twentyTeethLion) < 0);
        Assert.assertTrue(tenTeethLion.compareTo(uknownLion) < 0);
        Assert.assertTrue(twentyTeethLion.compareTo(tenTeethLion) > 0);
        Assert.assertTrue(uknownLion.compareTo(prairieLion) == 0);
    }
}
