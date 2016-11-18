package edu.wit.comp2000.group25.lists.Collections;

import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Enums.CardValue;

import java.util.Arrays;

/**
 * The hand of cards a player holds
 */
public class Hand extends Pile {
    private boolean hasBeenSplit;

    /**
     * Creates a new hand for a player
     */
    public Hand() {
        super();
        this.hasBeenSplit = false;
    }

    /**
     * Checks if the players hand contains an ace.
     *
     * @return True if the hand contains at least 1 Ace. False otherwise.
     */
    public boolean isSoftHand() {
        for (Card card : super.toArray()) {
            if (card.getValue() == CardValue.Ace)
                return true;
        }
        return false;
    }

    /**
     * Creates an array of integers representing the range of possible values
     * for a soft hand.
     *
     * @return Array of possible values
     */
    public int[] getSoftHandValues() {
        int aces = 0;//value = 1 or 11
        int total = 0;
        for (Card card : super.toArray()) {
            if (card.getValue() == CardValue.Ace)
                aces++;
            else
                total += card.getValue().getValue();
        }
        if (aces == 0) {
            return new int[]{total};
        }
        int[] hands = new int[aces + 1];
        for (int i = 0; i <= aces; i++) {
            hands[i] = total;
            hands[i] += (i * 11);
            hands[i] += ((aces - i));
        }
        return hands;
    }

    private int handValue(Hand hand) {
        int best = 0;
        for (int h : hand.getSoftHandValues()) {
            if (best == 0) {
                best = h;
            }
            if (h > best && h < 22) {
                best = h;
            }
        }
        return best;
    }

    /**
     * Checks if the hand can be split
     *
     * @return true if the hand can be split
     */
    public boolean canSplit() {
        Card[] c = this.toArray();
        if (c.length == 2) {
            if (c[0].getValue() == c[1].getValue()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks which hand is of higher value, but not black jack
     *
     * @param player The first hand to compare
     * @param dealer The second hand to compare
     * @return 1 if player is closer to blackjack than dealer. 0 if they are equal, -1 if dealer is closer.
     */
    public int compareTo(Hand player, Hand dealer) {
        int b1 = handValue(player);
        int b2 = handValue(dealer);
        if (b1 > 21 && b2 > 21) {
            return -1;
        } else if (b1 > 21 && b2 <= 21) {
            return -1;
        } else if (b1 > b2) {
            return 1;
        } else if (b1 == b2) {
            return 0;
        }
        return -1;
    }

    /**
     * @param h The hand to compare this hand against
     * @return 1 if this hand is closer to blackjack than h. 0 if they are equal, -1 if h is closer.
     */
    public int compare(Hand h) {
        return compareTo(this, h);
    }

    /**
     * Checks if hand is blackjack
     *
     * @return true if hand is blackjack
     */
    public boolean isBlackjack() {
        return Arrays.stream(this.getSoftHandValues()).anyMatch(i -> i == 21);
    }

    @Override
    public String toString() {
        return "Hand{" + Arrays.toString(this.toArray()) + "}";
    }

    /**
     * Checks if hand has busted
     *
     * @return True if hand has busted
     */
    public boolean hasBusted() {
        int[] values = this.getSoftHandValues();
        return Arrays.stream(values).allMatch(i -> i > 21);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Hand) {
            if (((Hand) o).getCardCount() == this.getCardCount()) {
                return 0 == this.compare((Hand) o);
            }
        }
        return false;
    }

    /**
     * Returns if the hand has been split
     *
     * @return If the hand already has been split
     */
    public boolean hasBeenSplit() {
        return hasBeenSplit;
    }

    /**
     * Sets if the hand has been split
     *
     * @param hasBeenSplit Value to set hasBeenSplit to
     */
    public void setHasBeenSplit(boolean hasBeenSplit) {
        this.hasBeenSplit = hasBeenSplit;
    }
}
