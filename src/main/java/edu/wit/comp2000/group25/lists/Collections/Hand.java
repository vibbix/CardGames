package edu.wit.comp2000.group25.lists.Collections;

import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Enums.CardValue;

import java.util.Arrays;

/**
 * The hand of cards a player holds
 */
public class Hand extends Pile {

    /**
     * Creates a new hand for a player
     */
    public Hand() {
        super();
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
     * Checks which hand is of higher value, but not black jack
     *
     * @param h1 The first hand to compare
     * @param h2 The second hand to compare
     * @return 1 if h1 is closer to blackjack than h2. 0 if they are equal, -1 if h2 is closer.
     */
    public int compareTo(Hand h1, Hand h2) {
        int b1 = handValue(h1);
        int b2 = handValue(h2);
        if (b1 > b2)
            return 1;
        else if (b1 == b2)
            return 0;
        return -1;
    }

    /**
     * @param h The hand to compare this hand against
     * @return 1 if this hand is closer to blackjack than h. 0 if they are equal, -1 if h is closer.
     */
    public int compare(Hand h) {
        return compareTo(this, h);
    }


    @Override
    public String toString(){
        return "Hand{"+ Arrays.toString(this.toArray())+"}";
    }

}
