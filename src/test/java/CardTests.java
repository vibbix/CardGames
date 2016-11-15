import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the card class
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

    @Test
    public void assertEqualTo() {
        Card c1 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Card c2 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Assert.assertEquals(c1, c2);
    }

    @Test
    public void equalTo() {
        Card c1 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Card c2 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Assert.assertEquals(true, c1.equals(c2));
    }

    @Test
    public void notEqualTo() {
        Card c1 = new Card(CardSuit.Clubs, CardValue.Ace);
        Card c2 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Assert.assertEquals(false, c1.equals(c2));
    }

    @Test
    public void compareToValues() {
        Card c1 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Card c2 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Assert.assertEquals(0, c1.compareTo(c2));
    }

    @Test
    public void compareValues() {
        Card c1 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Card c2 = new Card(CardSuit.Diamonds, CardValue.Two);
        Assert.assertEquals(-1, c1.compare(c1, c2));
    }

    @Test
    public void compareToSuits() {
        Card c1 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Card c2 = new Card(CardSuit.Hearts, CardValue.Ace);
        Assert.assertEquals(-1, c1.compareTo(c2));
    }

    @Test
    public void compareSuits() {
        Card c1 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Card c2 = new Card(CardSuit.Hearts, CardValue.Ace);
        Assert.assertEquals(-1, c1.compare(c1, c2));
    }
    @Test
    public void compareEqual() {
        Card c1 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Card c2 = new Card(CardSuit.Diamonds, CardValue.Ace);
        Assert.assertEquals(0, c1.compare(c1, c2));
    }
}
