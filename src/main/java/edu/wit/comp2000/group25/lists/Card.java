package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;

import java.util.Comparator;

/**
 * A single individual card
 */
public class Card implements Comparator<Card>, Comparable<Card>{
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
    public String toString(){
        String str = "Card{'" + this.suit.getSymbol();
        str += "':'" + this.value.toString() + "'}";
        return str;
    }

    @Override
    public int compareTo(Card o) {
        if(this.getSuit() != o.getSuit())
            return this.getSuit().compareTo(o.getSuit());
        return this.getValue().compareTo(o.getValue());
    }

    @Override
    public int compare(Card o1, Card o2) {
        if(o1.getSuit() != o2.getSuit())
            return o1.getSuit().compareTo(o2.getSuit());
        return o1.getValue().compareTo(o2.getValue());
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Card){
            if(((Card) o).getValue() == this.getValue()
                    && ((Card) o).getSuit() == this.getSuit())
                return true;
        }
        return false;
    }
}
