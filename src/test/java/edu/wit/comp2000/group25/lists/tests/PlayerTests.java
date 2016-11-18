package edu.wit.comp2000.group25.lists.tests;

import edu.wit.comp2000.group25.lists.*;
import edu.wit.comp2000.group25.lists.Collections.Hand;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for the player class
 */
public class PlayerTests {
    @Test
    public void placeWager() throws Exception {
        Blackjack game = mock(Blackjack.class);
        PlayerBank pb = new PlayerBank(1000);
        PlayerInput pi = new PlayerInput();
        when(game.getPlayerBank()).thenReturn(pb);
        when(game.getPlayerInput()).thenReturn(pi);
        Player player = new Player(game);
        player.placeWager(500);
        Assert.assertEquals(500, pi.getTotalAmountBet());
    }

    @Test
    public void insurance() throws Exception {

    }

    @Test
    public void split() throws Exception {

    }

    @Test
    public void doubleDown() throws Exception {

    }

    @Test
    public void hit() throws Exception {

    }

    @Test
    public void surrender() throws Exception {

    }

    @Test
    public void placeWager1() throws Exception {

    }

    @Test
    public void surrender1() throws Exception {

    }

    @Test
    public void hit1() throws Exception {

    }

    @Test
    public void doubleDown1() throws Exception {

    }

    @Test
    public void split1() throws Exception {

    }

    @Test
    public void reset() throws Exception {

    }

    @Test
    public void getShrunkenHands() throws Exception {
        Blackjack game = mock(Blackjack.class);
        PlayerBank pb = new PlayerBank(1000);
        Card[] cards = new Card[]{
                new Card(CardSuit.Clubs, CardValue.Ace),
                new Card(CardSuit.Diamonds, CardValue.Ten),
                new Card(CardSuit.Spades, CardValue.Five),
                new Card(CardSuit.Hearts, CardValue.Three)
        };
        when(game.getPlayerBank()).thenReturn(pb);
        when(game.dequeueCard()).thenReturn(cards[0], cards[1], cards[2], cards[3]);
        Player player = new Player(game);
        player.hit(0);
        player.hit();
        player.hit(1);
        player.hit(1);
        Hand h1 = new Hand();
        Hand h2 = new Hand();
        h1.enqueueCard(cards[0]);
        h1.enqueueCard(cards[1]);
        h2.enqueueCard(cards[2]);
        h2.enqueueCard(cards[3]);
        Assert.assertArrayEquals(new Hand[]{h1, h2}, player.getHands());
    }

    @Test
    public void createPlayer() {
        Blackjack game = mock(Blackjack.class);
        PlayerBank pb = new PlayerBank(1000);
        when(game.getPlayerBank()).thenReturn(pb);
        Player player = new Player(game);
    }
}
