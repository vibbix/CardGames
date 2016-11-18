import edu.wit.comp2000.group25.lists.Blackjack;
import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Collections.Deck;
import edu.wit.comp2000.group25.lists.Dealer;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by beznosm on 11/17/2016.
 */
public class DealerTests {
    @Test
    public void mustHitTest() {
        Blackjack game = mock(Blackjack.class);
        when(game.dequeueCard()).thenReturn(new Card(CardSuit.Clubs, CardValue.Ace),new Card(CardSuit.Clubs, CardValue.Ten));
        Dealer dealer = new Dealer(game);
        dealer.hitDeck();
        dealer.hitDeck();
        Assert.assertEquals(false, dealer.mustHit());
    }

    @Test
    public void mustHitSoftHandTest() {
        Blackjack game = mock(Blackjack.class);
        when(game.dequeueCard()).thenReturn(new Card(CardSuit.Clubs, CardValue.Ace),new Card(CardSuit.Clubs, CardValue.Six));
        Dealer dealer = new Dealer(game);
        dealer.hitDeck();
        dealer.hitDeck();
        Assert.assertEquals(true, dealer.mustHit());
    }

    @Test
    public void mustHitHardHand() {
        Blackjack game = mock(Blackjack.class);
        Dealer dealer = new Dealer(game);
        when(game.dequeueCard()).thenReturn(new Card(CardSuit.Clubs, CardValue.Ten),new Card(CardSuit.Clubs, CardValue.Six));
        dealer.hitDeck();
        dealer.hitDeck();
        Assert.assertEquals(true, dealer.mustHit());
    }

    @Test
    public void notHitHardHand() {
        Blackjack game = mock(Blackjack.class);
        when(game.dequeueCard()).thenReturn(new Card(CardSuit.Clubs, CardValue.Ten),new Card(CardSuit.Clubs, CardValue.Seven));
        Dealer dealer = new Dealer(game);
        dealer.hitDeck();
        dealer.hitDeck();
        Assert.assertEquals(false, dealer.mustHit());
    }

    @Test
    public void notHitSoftHand() {
        Blackjack game = mock(Blackjack.class);
        when(game.dequeueCard()).thenReturn(new Card(CardSuit.Clubs, CardValue.Ace),new Card(CardSuit.Clubs, CardValue.Eight));
        Dealer dealer = new Dealer(game);
        dealer.hitDeck();
        dealer.hitDeck();
        Assert.assertEquals(false, dealer.mustHit());
    }

}
