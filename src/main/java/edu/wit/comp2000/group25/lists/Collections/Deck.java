package edu.wit.comp2000.group25.lists.Collections;

import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;

/**
 * The card deck
 */
public class Deck extends Pile {
    /**
     * Creates a deck of 52 cards, shuffled.
     */
    public Deck() {
        this(1);
    }

    /**
     * Creates a deck with a specified multiple of the standard 52 deck of cards.
     *
     * @param decks Number of full sized decks to create. 0 will create an empty deck
     */
    public Deck(int decks) {
        super();
        if (decks < 0) {
            throw new IllegalArgumentException("Decks cannot be less than 1");
        }
        for (int i = 0; i < decks; i++) generateDeck();
        super.shuffle();
    }

    /**
     * Deals a card from the deck
     *
     * @return a card from the deck
     */
    public Card deal() {
        return super.dequeueCard();
    }

    /**
     * Generates and appends a single 52-card deck
     */
    public void generateDeck() {
        for (CardSuit cs : CardSuit.values()) {
            for (CardValue cv : CardValue.values()) {
                super.enqueueCard(new Card(cs, cv));
            }
        }
    }
}
