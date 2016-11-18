package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Collections.Hand;
import edu.wit.comp2000.group25.lists.Enums.PlayerMoves;

import java.util.ArrayList;
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
     *
     * @param money Amount to bet
     */
    public void placeWager(int money) {
        this.placeWager(money, 0);
    }

    /**
     * Places a insurance side bet
     *
     * @param money Amount to bet
     */
    public void insurance(int money) {
        hasMoneyForWager(money);
        this.blackjack.getPlayerInput().setCurrentInsurance(money);
    }

    /**
     * Splits the default hand
     *
     * @param money Amount new hand has for a wager
     */
    public void split(int money) {
        this.split(money, 0);
    }

    /**
     * Doubles down on the default hand
     *
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
     *
     * @param money   Amount to bet
     * @param handnum Selected hand
     */
    public void placeWager(int money, int handnum) {
        hasMoneyForWager(money);
        this.blackjack.getPlayerInput().setCurrentWager(money, handnum);
    }

    /**
     * Surrenders the selected hand, returning half the wager
     *
     * @param handnum Selected hand
     */
    public void surrender(int handnum) {
        //transfers 1/2 of hand wager to dealer
        int lost = this.getCurrentWager(handnum);
        this.getPlayerInput().setCurrentWager(0, handnum);
        this.playerBank.transferTo(this.blackjack.getDealerBank(), lost / 2);
    }

    /**
     * Gets a additional card added to the specified hand
     *
     * @param handnum The specified hand
     */
    public void hit(int handnum) {
        if (this.hands[handnum] == null) {
            this.hands[handnum] = new Hand();
        }
        this.hands[handnum].enqueueCard(this.blackjack.dequeueCard());
    }

    /**
     * Increases the wager of the specified hand up to to double the value of the
     * current wager.
     *
     * @param wager   Amount to increase the bet by (up to the current amount)
     * @param handnum Specified hand
     */
    public void doubleDown(int wager, int handnum) {
        hasMoneyForWager(wager);
        int cwager = this.getCurrentWager(handnum);
        this.wagerExceedsInitialBet(wager, cwager);
        this.hit(handnum);
        this.placeWager(wager + cwager, handnum);
    }

    /**
     * Splits the current hand into two.
     *
     * @param wager   Amount to wager (up to the current amount)
     * @param handnum Specified hand
     */
    public void split(int wager, int handnum) {
        hasMoneyForWager(wager);
        int cwager = this.getCurrentWager(handnum);
        this.wagerExceedsInitialBet(wager, cwager);
        if (handnum > 2) {
            throw new IllegalArgumentException("You cannot split into having more than 4 hands");
        }
        if (this.hands[handnum + 1] == null) {
            this.hands[handnum + 1] = new Hand();
        }
        Card c = this.hands[0].dequeueCard();
        this.hands[handnum + 1].enqueueCard(c);
        this.hasSplit = true;
    }

    //endregion
    //region helper methods

    /**
     * Gets the current wager for the hand.
     *
     * @param handnum Specified hand
     * @return The current wager for the specified handnum.
     */
    private int getCurrentWager(int handnum) {
        return this.blackjack.getPlayerInput().getTotalAmountBet(handnum);
    }

    /**
     * Checks if the currentwager exceeds the original amount.
     *
     * @param currentwager  The current wager
     * @param originalwager The original wager
     * @throws IllegalArgumentException Thrown if currentwager exceeds the originalwager
     */
    private void wagerExceedsInitialBet(int currentwager, int originalwager) {
        if (currentwager > originalwager) {
            throw new IllegalArgumentException("Current wager cannot exceed the original wager");
        }
    }

    /**
     * Checks if the player has enough money increase the wager
     *
     * @param wager Amount to increase wager by
     * @throws IllegalArgumentException Thrown if player runs out of money
     */
    private void hasMoneyForWager(int wager) {
        //get amount currently bet
        int currentmoney = this.playerBank.getMoney();
        currentmoney -= getPlayerInput().getTotalAmountBet();
        currentmoney -= wager;
        if (currentmoney < 0) {
            throw new IllegalArgumentException("Player does not have enough money to complete the transaction");
        }
    }

    /**
     * Gets the player input class from the blackjack parent class
     *
     * @return The players input
     */
    private PlayerInput getPlayerInput() {
        return this.blackjack.getPlayerInput();
    }

    /**
     * Returns a list of available moves to play
     *
     * @param handnum The specified hand
     * @return The available moves
     */
    public PlayerMoves[] getAvailableMoves(int handnum) {
        ArrayList<PlayerMoves> pm = new ArrayList<>();
        pm.add(PlayerMoves.Stand);
        pm.add(PlayerMoves.Hit);
        pm.add(PlayerMoves.Surrender);
        pm.add(PlayerMoves.Double);
        if (this.hands[handnum].canSplit() && this.getHands().length < 4)
            pm.add(PlayerMoves.Split);
        return (PlayerMoves[]) pm.toArray();
    }

    /**
     * Resets the player for another round.
     */
    public void reset() {
        for (int i = 0; i < 4; i++) {
            this.hands[i] = null;
        }
        this.hands[0] = new Hand();
        this.hasSplit = false;
    }

    /**
     * gets the players current hands
     *
     * @return Array of hands
     */
    public Hand[] getHands() {
        return Arrays.stream(this.hands).filter(h -> h != null).toArray(Hand[]::new);
    }

    /**
     * Gets if the player has split a hand.
     *
     * @return True if the player has already split.
     */
    public boolean hasSplit() {
        return hasSplit;
    }

    //endregion
}
