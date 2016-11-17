import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Collections.Deck;
import edu.wit.comp2000.group25.lists.Dealer;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import org.junit.Test;

/**
 * Created by beznosm on 11/17/2016.
 */
public class DealerTests {
    @Test
    public void mustHitTest(){
        Dealer dealer = new Dealer();
        Deck d = new Deck();
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        d.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        dealer.hitDeck(d);
    }
}
