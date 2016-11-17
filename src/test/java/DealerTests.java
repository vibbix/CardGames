import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Collections.Deck;
import edu.wit.comp2000.group25.lists.Dealer;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by beznosm on 11/17/2016.
 */
public class DealerTests {
    @Test
    public void mustHitTest() {
        Dealer dealer = new Dealer();
        Deck d = new Deck(0);
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        dealer.hitDeck(d);
        dealer.hitDeck(d);
        Assert.assertEquals(false, dealer.mustHit());
    }

    @Test
    public void mustHitSoftHandTest() {
        Dealer dealer = new Dealer();
        Deck d = new Deck(0);
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Six));
        dealer.hitDeck(d);
        dealer.hitDeck(d);
        Assert.assertEquals(true, dealer.mustHit());
    }

    @Test
    public void mustHitHardHand() {
        Dealer dealer = new Dealer();
        Deck d = new Deck(0);
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Six));
        dealer.hitDeck(d);
        dealer.hitDeck(d);
        Assert.assertEquals(true, dealer.mustHit());
    }

    @Test
    public void notHitHardHand() {
        Dealer dealer = new Dealer();
        Deck d = new Deck(0);
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Seven));
        dealer.hitDeck(d);
        dealer.hitDeck(d);
        Assert.assertEquals(false, dealer.mustHit());
    }

    @Test
    public void notHitSoftHand() {
        Dealer dealer = new Dealer();
        Deck d = new Deck(0);
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Eight));
        dealer.hitDeck(d);
        dealer.hitDeck(d);
        Assert.assertEquals(false, dealer.mustHit());
    }
}
