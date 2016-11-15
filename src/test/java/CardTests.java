import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by beznosm on 11/15/2016.
 */
public class CardTests {
    @Test
    public void cardToString(){
        Card c = new Card(CardSuit.Diamonds, CardValue.Ace);
        Assert.assertEquals("Card{'♦':'Ace'}", c.toString());
    }
    @Test
    public void getSuit(){
        Card c = new Card(CardSuit.Diamonds, CardValue.Ace);
       Assert.assertEquals(CardSuit.Diamonds, c.getSuit());
    }
    @Test
    public void getValue(){
        Card c = new Card(CardSuit.Diamonds, CardValue.Ace);
        Assert.assertEquals(CardValue.Ace, c.getValue());
    }
}
