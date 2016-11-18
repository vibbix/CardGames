package edu.wit.comp2000.group25.lists;

import java.util.Arrays;

/**
 * The class for player input
 */
public class PlayerInput {
    private int[] currentWager;
    private int currentInsurance;
    private boolean playNextMatch;
    private boolean playerTurnDone;
    private boolean gotInput;

    /**
     * Creates a new instance of the player input store
     */
    public PlayerInput() {
        this.currentWager = new int[]{-1, -1, -1, -1};
        this.currentInsurance = -1;
        this.playNextMatch = false;
        this.playerTurnDone = false;
        this.gotInput = false;
    }


    //region Getters/Setters

    /**
     * Gets the wager set for the current hand index
     *
     * @param index The specifed hand inex
     * @return The current wager for the specified hand
     */
    public int getTotalAmountBet(int index) {
        return currentWager[index];
    }

    /**
     * Sets the wager amount for the specified hand index
     *
     * @param currentWager The amount to set to
     * @param index        The specified index
     */
    public void setCurrentWager(int currentWager, int index) {
        this.currentWager[index] = currentWager;
        this.gotInput = true;
    }

    /**
     * Gets the sum total of the current wagers (including insurance)
     *
     * @return Total amount bet
     */
    public int getTotalAmountBet() {
        int total = Arrays.stream(this.currentWager).filter(i -> i > -1).sum();
        if (this.getCurrentInsurance() > -1) {
            total += this.getCurrentInsurance();
        }
        return total;
    }

    /**
     * Gets the current insurance side bet
     *
     * @return The insurance side bet
     */
    public int getCurrentInsurance() {
        return currentInsurance;
    }

    /**
     * Sets the current insurance side bet
     *
     * @param currentInsurance The insurance side bet to set to
     */
    public void setCurrentInsurance(int currentInsurance) {
        this.currentInsurance = currentInsurance;
        this.gotInput = true;
    }

    /**
     * Get whether the user wants to play another match
     *
     * @return The playNextMatch property value
     */
    public boolean isPlayNextMatch() {
        return playNextMatch;
    }

    /**
     * Sets the playNextMatch field
     *
     * @param playNextMatch value to set playNextMatch to
     */
    public void setPlayNextMatch(boolean playNextMatch) {
        this.playNextMatch = playNextMatch;
        this.gotInput = true;
    }

    /**
     * Gets the playerTurnDone property
     *
     * @return true if the players turn is done
     */
    public boolean isPlayerTurnDone() {
        return playerTurnDone;
    }

    /**
     * Sets if the players turn is done
     *
     * @param playerTurnDone value to set playerTurnDone to
     */
    public void setPlayerTurnDone(boolean playerTurnDone) {
        this.playerTurnDone = playerTurnDone;
        this.gotInput = true;
    }

    /**
     * Checks if the object has been modified
     *
     * @return Whether the object has been modified
     */
    public boolean getGotInput() {
        return this.gotInput;
    }
    //endregion
}
