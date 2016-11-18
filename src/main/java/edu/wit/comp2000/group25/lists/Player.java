package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Collections.Hand;
import edu.wit.comp2000.group25.lists.Enums.PlayerMoves;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

/**
 * The blackjack player
 */
public class Player {
    private Hand[] hands;
    private Blackjack blackjack;
    private PlayerBank playerBank;
    private boolean hasSplit;

    public Player(Blackjack blackjack) {
        this.hands = new Hand[4];
        this.blackjack = blackjack;
        this.playerBank = blackjack.getPlayerBank();
        this.hasSplit = false;
    }

    //region player moves

    /**
     * Places a wager on the default hand
     * @param money Amount to bet
     */
    public void placeWager(int money) {
        this.placeWager(money, 0);
    }
    /**
     * Places a insurance side bet
     * @param money Amount to bet
     */
    public void insurance(int money) {
        this.blackjack.getPlayerInput().setCurrentInsurance(money);
    }
    /**
     * Splits the default hand
     * @param money Amount new hand has for a wager
     */
    public void split(int money) {
        this.split(money, 0);
    }

    /**
     * Doubles down on the default hand
     * @param money Money to wager
     */
    public void doubleDown(int money) {
        this.doubleDown(money, 0);
    }

    /**
     * Gets a additional card added to the default hand
     */
    public void hit() {
        this.hit(0);
    }

    /**
     * Surrenders the default hand, returning half the wager.
     */
    public void surrender() {
        this.surrender(0);
    }

    /**
     * Places a wager on a specified hand
     * @param money Amount to bet
     * @param handnum Selected hand
     */
    public void placeWager(int money, int handnum){
        this.blackjack.getPlayerInput().setCurrentWager(money, handnum);
    }


    /**
     * Surrenders the selected hand, returning half the wager
     * @param handnum Selected hand
     */
    public void surrender(int handnum) {
        handCheck(handnum);
    }

    public void hit(int handnum) {
        handCheck(handnum);
        canExecuteMove(PlayerMoves.Hit);
        throw new NotImplementedException();
    }

    public void doubleDown(int wager, int handnum) {
        handCheck(handnum);
        throw new NotImplementedException();
    }

    public void split(int wager, int handnum) {
        handCheck(handnum);
        throw new NotImplementedException();
    }

    //endregion
    //region helper methods
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

    /**
     * gets the players current hands
     * @return Array of hands
     */
    public Hand[] getHands(){
        return Arrays.stream(this.hands).filter( h -> h != null).toArray(Hand[]::new);
    }
    //endregion
}
