import edu.wit.comp2000.group25.lists.Enums.Chips;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by beznosm on 11/10/2016.
 */
public class ChipsTest {
    @Test
    public void TestChipValue(){
        Chips thousand = Chips.Thousand;
        Assert.assertEquals(1000, thousand.getChipValue());
    }

}
