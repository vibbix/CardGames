package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Collections.Deck;
import edu.wit.comp2000.group25.lists.Collections.Hand;

import java.util.Arrays;

/**
 * The blackjack dealer
 */
@SuppressWarnings("SuspiciousMethodCalls")
public class Dealer {
    private Hand dealerHand;
    private Game g;
    private boolean hasRevealed;

    /**
     * Creates a new blackjack dealer
     */
    public Dealer() {
        this.dealerHand = new Hand();
        this.hasRevealed = false;
    }

    /**
     * @return True if the
     */
    private boolean checkForBlackjack() {
        return Arrays.asList(this.dealerHand.getSoftHandValues()).contains(21);
    }

    /**
     * Checks if the dealer must hit anothe rcard.
     *
     * @return True if dealer has hard 16, soft 17, or less
     */
    public boolean mustHit() {
        //if hard 16 or soft 17 must hit
        if (!this.dealerHand.isSoftHand()) {
            return (this.dealerHand.getSoftHandValues()[0] <= 16);
        }
        return Arrays.asList(this.dealerHand.toArray()).contains(17);
    }

    public void hitDeck(Deck d) {
        this.dealerHand.enqueueCard(d.dequeueCard());
    }

    /**
     * Reveals the hole card
     */
    public void revealCards() {
        this.hasRevealed = true;
    }

    /**
     * Gets the list of cards
     * @return Array of cards visible to the player
     */
    public Card[] getCards() {
        if (this.hasRevealed)
            return Arrays.copyOfRange(this.dealerHand.toArray(), 0, 1);
        return this.dealerHand.toArray();
    }


}
