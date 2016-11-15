package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Enums.CardSuit;
import edu.wit.comp2000.group25.lists.Enums.CardValue;

/**
 * The main method
 */
public class Main {
    public static void main(String[] args){
        for(CardSuit cs: CardSuit.values())
            for (CardValue cv: CardValue.values())
                System.out.println(new Card(cs,cv).toString());
    }
}
