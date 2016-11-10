package edu.wit.comp2000.group25.lists.Enums;

/**
 * Created by beznosm on 11/10/2016.
 */
public enum CardSuit {
    Clubs('♣'),
    Diamonds('♦'),
    Hearts('♥'),
    Spades('♠');
    private char symbol;
    private CardSuit(char Symbol){
        this.symbol = Symbol;
    }

    /**
     * @return The cards unicode symbol
     */
    public char getSymbol(){
        return this.getSymbol();
    }
}
