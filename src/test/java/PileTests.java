import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Collections.Pile;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Tests for a pile of cards
 */
public class PileTests {
    @Test
    public void defaultConstructorTest() {
        Pile p = new Pile();
        Assert.assertEquals(0, p.getCardCount());
    }

    @Test
    public void enqueueTest() {
        Pile p = new Pile();
        p.enqueueCard(new Card(CardSuit.Diamonds, CardValue.Ten));
        Assert.assertEquals(new Card(CardSuit.Diamonds, CardValue.Ten), p.dequeueCard());
    }

    @Test(expected = IllegalArgumentException.class)
    public void enqueueNull() {
        Pile p = new Pile();
        p.enqueueCard(null);
    }

    @Test
    public void EmptyToArray() {
        Pile p = new Pile();
        Assert.assertArrayEquals(new Card[]{}, p.toArray());
    }

    @Test
    public void toArray() {
        Pile p = new Pile();
        Card c = new Card(CardSuit.Diamonds, CardValue.Ten);
        p.enqueueCard(c);
        Assert.assertArrayEquals(new Card[]{c}, p.toArray());
    }

    @Test
    public void shuffle() {
        Card[] cexpect = new Card[52];
        int index = 0;
        Pile p = new Pile();
        for (CardSuit cs : CardSuit.values()) {
            for (CardValue cv : CardValue.values()) {
                Card c = new Card(cs, cv);
                p.enqueueCard(c);
                cexpect[index] = c;
                index++;
            }
        }
        p.shuffle();
        assertThat(cexpect, not(equalTo(p.toArray())));

    }

    @Test
    public void sort() {
        Card[] cexpect = new Card[52];
        int index = 0;
        Pile p = new Pile();
        for (CardSuit cs : CardSuit.values()) {
            for (CardValue cv : CardValue.values()) {
                Card c = new Card(cs, cv);
                p.enqueueCard(c);
                cexpect[index++] = c;
            }
        }
        p.shuffle();
        p.sort();
        Assert.assertArrayEquals(cexpect, p.toArray());
    }
}
