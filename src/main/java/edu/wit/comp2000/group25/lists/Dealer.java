package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Collections.Hand;

import java.util.Arrays;

/**
 * The blackjack dealer
 */
@SuppressWarnings("SuspiciousMethodCalls")
public class Dealer {
    private Hand dealerHand;
    private Blackjack blackjack;
    private boolean hasRevealed;

    /**
     * Creates a new blackjack dealer
     *
     * @param blackjack The current game
     */
    public Dealer(Blackjack blackjack) {
        this.blackjack = blackjack;
        this.dealerHand = new Hand();
        this.hasRevealed = false;
    }

    /**
     * Checks the dealers hand for blackjack.
     *
     * @return True if the dealers hand is blackjack.
     */
    public boolean hasBlackjack() {
        return this.dealerHand.isBlackjack();
    }

    /**
     * Checks if the dealer must hit another card.
     *
     * @return True if dealer has at most a soft 17 or hard 16.
     */
    public boolean mustHit() {
        //if hard 16 or soft 17 must hit
        if (this.dealerHand.isSoftHand()) {
            int[] values = this.dealerHand.getSoftHandValues();
            return values[values.length - 1] <= 17;
        }
        return this.dealerHand.getSoftHandValues()[0] <= 16;
    }

    /**
     * Adds a card to the dealers hand
     */
    public void hitDeck() {
        this.dealerHand.enqueueCard(this.blackjack.dequeueCard());
    }

    /**
     * Reveals the hole card
     */
    public void revealCards() {
        this.hasRevealed = true;
    }

    /**
     * Gets the list of cards
     *
     * @return Array of cards visible to the player
     */
    public Card[] getCards() {
        if (!this.hasRevealed)
            return Arrays.copyOfRange(this.dealerHand.toArray(), 0, 1);
        return this.dealerHand.toArray();
    }

    /**
     * Gets the dealers hand
     * @return The dealers hand
     */
    public Hand getHand(){
        return this.dealerHand;
    }


}
