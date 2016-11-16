package edu.wit.comp2000.group25.lists.Collections;

import edu.wit.comp2000.group25.lists.Card;
import edu.wit.comp2000.group25.lists.Enums.CardValue;

/**
 * The hand of cards a player holds
 */
public class Hand extends Pile{

    /**
     * Creates a new hand for a player
     */
    public Hand(){
        super();
    }

    /**
     * Checks if the players hand contains an ace.
     * @return True if the hand contains at least 1 Ace. False otherwise.
     */
    public boolean isSoftHand(){
        for(Card card:super.toArray()){
            if(card.getValue() == CardValue.Ace)
                return true;
        }
        return false;
    }

    /**
     *
     * @return An array of integers specifying the range of possible values for a soft hands
     */
    public int[] getSoftHandValues(){
        int aces = 0;//value = 1 or 11
        int total = 0;
        for(Card card:super.toArray()){
            if(card.getValue() == CardValue.Ace)
                aces++;
            else
                total += card.getValue().getValue();
        }
        if(aces == 0){
            return new int[]{total};
        }
        int[] hands = new int[aces + 1];
        for(int i = 0; i <= aces; i++){
            hands[i] = total;
            hands[i] +=(i*11);
            hands[i] += ((aces-i));
        }
        return hands;
    }
}
