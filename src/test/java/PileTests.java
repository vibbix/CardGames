import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import edu.wit.comp2000.group25.lists.Pile;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by beznosm on 11/14/2016.
 */
public class PileTests {
    @Test
    public void defaultConstructorTest(){
        Pile p = new Pile();
        Assert.assertEquals(0, p.getCardCount());
    }
    @Test
    public void enqueueTest(){
        Pile p = new Pile();
        p.enqueueCard(new Card(CardSuit.Diamonds, CardValue.Ten));
        Assert.assertEquals(new Card(CardSuit.Diamonds, CardValue.Ten), p.dequeueCard());
    }
    @Test(expected = IllegalArgumentException.class)
    public void enqueueNull(){
        Pile p = new Pile();
        p.enqueueCard(null);
    }
    @Test
    public void EmptyToArray(){
        Pile p = new Pile();
        Assert.assertArrayEquals(new Card[]{}, p.toArray());
    }
    @Test
    public void toArray(){
        Pile p = new Pile();
        Card c = new Card(CardSuit.Diamonds, CardValue.Ten);
        p.enqueueCard(c);
        Assert.assertArrayEquals(new Card[]{c}, p.toArray());
    }
}