import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import edu.wit.comp2000.group25.lists.Hand;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by beznosm on 11/14/2016.
 */
public class HandTests {
    @Test
    public void getSoftHandValuesAllAces(){
        Hand hand = new Hand();
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Assert.assertArrayEquals(new int[]{2, 12, 22}, hand.getSoftHandValues());
    }
    @Test
    public void getSoftHandValuesNoAces(){
        Hand hand = new Hand();
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        Assert.assertArrayEquals(new int[]{20}, hand.getSoftHandValues());
    }
    @Test
    public void getSoftHandWithOneAce(){
        Hand hand = new Hand();
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        Assert.assertArrayEquals(new int[]{11, 21}, hand.getSoftHandValues());
    }
    @Test
    public void getSoftHandWithEmptyHand(){
        Hand hand = new Hand();
        Assert.assertArrayEquals(new int[]{0}, hand.getSoftHandValues());
    }
}
