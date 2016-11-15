import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by beznosm on 11/15/2016.
 *
 */

public class CardSuitTests {
    @Test
    public void getClubsSuit(){
        CardSuit cs = CardSuit.Clubs;
        Assert.assertEquals('♣', cs.getSymbol());
    }
    @Test
    public void getHeartsSuit(){
        CardSuit cs = CardSuit.Hearts;
        Assert.assertEquals('♥', cs.getSymbol());
    }
    @Test
    public void getSpadesSuit(){
        CardSuit cs = CardSuit.Spades;
        Assert.assertEquals('♠', cs.getSymbol());
    }
    @Test
    public void getDiamondsSuit(){
        CardSuit cs = CardSuit.Diamonds;
        Assert.assertEquals('♦', cs.getSymbol());
    }
}
