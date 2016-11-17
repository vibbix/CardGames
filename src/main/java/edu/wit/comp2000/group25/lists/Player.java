package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Collections.Hand;
import edu.wit.comp2000.group25.lists.Enums.PlayerMoves;

/**
 * The blackjack player
 */
public class Player {
    private Hand[] hands;
    private Game game;
    private boolean hasSplit;

    public Player(Game game) {
        this.hands = new Hand[4];
        this.game = game;
        this.hasSplit = false;
    }
    //region player moves
    public void insurance(double wager){

    }
    public void split(double wager) {
        split(wager, 0);
    }

    public void doubleDown(double wager) {
        this.doubleDown(wager, 0);
    }

    public void hit() {
        this.hit(0);
    }

    public void surrender() {
        this.surrender(0);
    }

    public void stand() {
        this.stand(0);
    }

    public void stand(int handnum) {
        handCheck(handnum);
    }

    public void surrender(int handnum) {
        handCheck(handnum);
    }

    public void hit(int handnum) {
        handCheck(handnum);
        canExecuteMove(PlayerMoves.Hit);
    }

    public void doubleDown(double wager, int handnum) {
        handCheck(handnum);
    }

    public void split(double wager, int handnum) {
        handCheck(handnum);
    }
    //endregion
    private void handCheck(int hand) {
        if (hand > 4)
            throw new IllegalArgumentException("Hand index has to be lower than 4.");
    }
    private boolean canExecuteMove(PlayerMoves pm){
        return true;
    }

    public void reset(){
        for(int i =0; i < 4; i++){
            this.hands[i] = null;
        }
        this.hands[0] = new Hand();
    }
}
