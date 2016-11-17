package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Collections.Hand;
import edu.wit.comp2000.group25.lists.Enums.PlayerMoves;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * The blackjack player
 */
public class Player {
    private Hand[] hands;
    private Game game;
    private PlayerBank playerBank;
    private boolean hasSplit;

    public Player(Game game) {
        this.hands = new Hand[4];
        this.game = game;
        this.playerBank = game.getPlayerBank();
        this.hasSplit = false;
    }

    //region player moves
    public void placeWager(int money) {

    }

    public void insurance(double wager) {
        throw new NotImplementedException();
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
        throw new NotImplementedException();
    }

    public void surrender(int handnum) {
        handCheck(handnum);
        throw new NotImplementedException();
    }

    public void hit(int handnum) {
        handCheck(handnum);
        canExecuteMove(PlayerMoves.Hit);
        throw new NotImplementedException();
    }

    public void doubleDown(double wager, int handnum) {
        handCheck(handnum);
        throw new NotImplementedException();
    }

    public void split(double wager, int handnum) {
        handCheck(handnum);
        throw new NotImplementedException();
    }

    //endregion
    private void handCheck(int hand) {
        if (hand > 4)
            throw new IllegalArgumentException("Hand index has to be lower than 4.");
    }

    private boolean canExecuteMove(PlayerMoves pm) {
        throw new NotImplementedException();
    }

    public void reset() {
        for (int i = 0; i < 4; i++) {
            this.hands[i] = null;
        }
        this.hands[0] = new Hand();
    }
}
