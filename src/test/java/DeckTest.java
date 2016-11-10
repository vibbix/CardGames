import edu.wit.comp2000.group25.lists.Deck;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by beznosm on 11/10/2016.
 */
public class DeckTest {
    @Test
    public void createSimpleDeck(){
        Deck d = new Deck();
        Assert.assertEquals(52, d.getCardCount());
    }
    @Test
    public void createEmptyDeck(){
        Deck d = new Deck(0);
        Assert.assertEquals(0, d.getCardCount());
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void dequeueDeck(){
        Deck d = new Deck(0);
        d.dequeueCard();
    }
}
