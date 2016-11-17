import edu.wit.comp2000.group25.lists.Enums.Chips;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Tests for chips
 */
public class ChipsTests {
    @Test
    public void TestChipValue() {
        Chips thousand = Chips.Thousand;
        Assert.assertEquals(1000, thousand.getChipValue());
    }

}
