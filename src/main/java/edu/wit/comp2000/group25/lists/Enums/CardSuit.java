package edu.wit.comp2000.group25.lists.Enums;


/**
 * Suits for a card
 */
public enum CardSuit {
    Clubs('♣'),
    Diamonds('♦'),
    Hearts('♥'),
    Spades('♠');
    private char symbol;

    CardSuit(char Symbol) {
        this.symbol = Symbol;
    }

    /**
     * @return The cards unicode symbol
     */
    public char getSymbol() {
        return this.symbol;
    }
}
