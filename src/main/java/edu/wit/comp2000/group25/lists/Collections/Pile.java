package edu.wit.comp2000.group25.lists.Collections;

import edu.wit.comp2000.group25.lists.Card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A pile of unsorted cards
 */
public class Pile {
    private ArrayList<Card> cardCollection;

    /**
     * Creates a new pile of cards
     */
    public Pile() {
        this.cardCollection = new ArrayList<>();
    }

    /**
     * Removes and returns the card on top of the pile
     *
     * @return The card on top of the pile,
     */
    public Card dequeueCard() {
        if (this.cardCollection.size() != 0)
            return this.cardCollection.remove(0);
        throw new ArrayIndexOutOfBoundsException("Ran out of cards to deal.");
    }

    /**
     * Adds a card to a pile
     *
     * @param card Card to add to pile
     */
    public void enqueueCard(Card card) {
        if (card == null)
            throw new IllegalArgumentException("Card cannot be null");
        this.cardCollection.add(card);
    }

    /**
     * Gets the array representation of all the cards in the pile.
     *
     * @return The array of cards in the pile.
     */
    public Card[] toArray() {
        Card[] carray = new Card[this.cardCollection.size()];
        return this.cardCollection.toArray(carray);
    }

    /**
     * Shuffles the pile
     */
    public void shuffle() {
        Collections.shuffle(this.cardCollection);
    }

    public void sort() {
        Collections.sort(this.cardCollection);
    }

    /**
     * Gets the cards in the pile
     *
     * @return Number of cards in the pile
     */
    public int getCardCount() {
        return this.cardCollection.size();
    }
}
