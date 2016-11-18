package edu.wit.comp2000.group25.lists.tests;

import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Collections.Hand;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for a hand of cards
 */
public class HandTests {
    @Test
    public void getSoftHandValuesAllAces() {
        Hand hand = new Hand();
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Assert.assertArrayEquals(new int[]{2, 12, 22}, hand.getSoftHandValues());
    }

    @Test
    public void getSoftHandValuesNoAces() {
        Hand hand = new Hand();
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        Assert.assertArrayEquals(new int[]{20}, hand.getSoftHandValues());
    }

    @Test
    public void getSoftHandWithOneAce() {
        Hand hand = new Hand();
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        Assert.assertArrayEquals(new int[]{11, 21}, hand.getSoftHandValues());
    }

    @Test
    public void getSoftHandWithEmptyHand() {
        Hand hand = new Hand();
        Assert.assertArrayEquals(new int[]{0}, hand.getSoftHandValues());
    }

    @Test
    public void isNotSoftHand() {
        Hand hand = new Hand();
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        Assert.assertEquals(false, hand.isSoftHand());
    }

    @Test
    public void isSoftHand() {
        Hand hand = new Hand();
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        hand.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Assert.assertEquals(true, hand.isSoftHand());
    }

    @Test
    public void compareEqualHands() {
        Hand h1 = new Hand();
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Hand h2 = new Hand();
        h2.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h2.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Assert.assertEquals(0, h1.compare(h2));
    }

    @Test
    public void compareToEqualHands() {
        Hand h1 = new Hand();
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Hand h2 = new Hand();
        h2.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h2.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Assert.assertEquals(0, h1.compareTo(h1, h2));
    }

    @Test
    public void compareToLosingHand() {
        Hand h1 = new Hand();
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        Hand h2 = new Hand();
        h2.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h2.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Assert.assertEquals(-1, h1.compareTo(h1, h2));
    }

    @Test
    public void compareToWinningHand() {
        Hand h1 = new Hand();
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Hand h2 = new Hand();
        h2.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h2.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        Assert.assertEquals(1, h1.compare(h2));
    }

    @Test
    public void toStringTest() {
        Hand h1 = new Hand();
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Assert.assertEquals("Hand{[Card{'♣':'Ten'}, Card{'♣':'Ace'}]}", h1.toString());
    }

    @Test
    public void notEqualToObject() {
        Hand h = new Hand();
        h.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Assert.assertEquals(false, h.equals("hello"));
    }

    @Test
    public void notEqualToDifferentLength() {
        Hand h1 = new Hand();
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Hand h2 = new Hand();
        h2.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        Assert.assertEquals(false, h1.equals(h2));
    }

    @Test
    public void equalTo() {
        Hand h1 = new Hand();
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Hand h2 = new Hand();
        h2.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ten));
        h2.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Assert.assertEquals(true, h1.equals(h2));
    }

    @Test
    public void canSplit() {
        Hand h1 = new Hand();
        h1.enqueueCard(new Card(CardSuit.Hearts, CardValue.Ace));
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Ace));
        Assert.assertEquals(true, h1.canSplit());
    }

    @Test
    public void cannotSplit() {
        Hand h1 = new Hand();
        h1.enqueueCard(new Card(CardSuit.Hearts, CardValue.Ace));
        h1.enqueueCard(new Card(CardSuit.Clubs, CardValue.Eight));
        Assert.assertEquals(false, h1.canSplit());
    }

}
