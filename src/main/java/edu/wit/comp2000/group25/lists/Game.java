package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Collections.Deck;

/**
 * The game class
 */
public class Game {
    private enum GameState{

    };
    private Deck deck;

    /**
     * Creates a new game
     * @param decks Numbers of decks to play with
     */
    public Game(int decks){
        this.deck = new Deck(decks);
    }
    public void dealerHit(){

    }



}
