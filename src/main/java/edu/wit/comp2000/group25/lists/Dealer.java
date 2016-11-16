package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Collections.Hand;

import java.util.Arrays;

/**
 * The blackjack dealer
 */
@SuppressWarnings("SuspiciousMethodCalls")
public class Dealer {
    private Hand dealerHand;

    /**
     * Creates a new blackjack dealer
     */
    public Dealer() {
        dealerHand = new Hand();
    }

    /**
     * @return True if the
     */
    private boolean checkForBlackjack() {
        return Arrays.asList(dealerHand.getSoftHandValues()).contains(21);
    }

    /**
     * Checks if the dealer must hit anothe rcard.
     * @return True if dealer has hard 16, soft 17, or less
     */
    public boolean mustHit() {
        //if hard 16 or soft 17 must hit
        if (!this.dealerHand.isSoftHand()) {
            return (this.dealerHand.getSoftHandValues()[0] <= 16);
        }
        return Arrays.asList(this.dealerHand.toArray()).contains(17);
    }

}
