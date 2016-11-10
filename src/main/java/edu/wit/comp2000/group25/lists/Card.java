package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;

/**
 * A single individual card
 */
public class Card {
    private final CardSuit suit;
    private final CardValue value;
    public Card(CardSuit cardSuit, CardValue cardValue){
        this.suit = cardSuit;
        this.value = cardValue;
    }
    /**
     * Gets the cards suit
     * @return the suit
     */
    public CardSuit getSuit() {
        return suit;
    }

    /**
     * Gets the cards value
     * @return the value
     */
    public CardValue getValue() {
        return value;
    }
}
