package edu.wit.comp2000.group25.lists.tests;

import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Collections.Deck;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the deck class
 */
public class DeckTests {
    @Test(expected = IllegalArgumentException.class)
    public void createIllegalDeck() {
        Deck d = new Deck(-1);
    }

    @Test
    public void createSimpleDeck() {
        Deck d = new Deck();
        Assert.assertEquals(52, d.getCardCount());
    }

    @Test
    public void createEmptyDeck() {
        Deck d = new Deck(0);
        Assert.assertEquals(0, d.getCardCount());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void dequeueEmptyDeck() {
        Deck d = new Deck(0);
        d.deal();
    }

    @Test
    public void dealCard() {
        Deck d = new Deck(0);
        Card c = new Card(CardSuit.Diamonds, CardValue.Ace);
        d.enqueueCard(c);
        Assert.assertEquals(c, d.deal());
    }

    @Test
    public void generateDeck() {
        Deck d = new Deck(0);
        d.generateDeck();
        Assert.assertEquals(52, d.getCardCount());
    }
}
