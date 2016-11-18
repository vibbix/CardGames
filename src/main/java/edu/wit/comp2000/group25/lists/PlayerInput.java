package edu.wit.comp2000.group25.lists;

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
    public PlayerInput(){
        this.currentWager = new int[]{-1,-1,-1,-1};
        this.currentInsurance = -1;
        this.playNextMatch = false;
        this.playerTurnDone = false;
        this.gotInput = false;
    }
    //region Getters/Setters
    public int getCurrentWager(int index) {
        return currentWager[index];
    }

    public void setCurrentWager(int currentWager, int index) {
        this.currentWager[index] = currentWager;
        this.gotInput = true;
    }

    public int getCurrentInsurance() {
        return currentInsurance;
    }

    public void setCurrentInsurance(int currentInsurance) {
        this.currentInsurance = currentInsurance;
        this.gotInput = true;
    }

    public boolean isPlayNextMatch() {
        return playNextMatch;
    }

    public void setPlayNextMatch(boolean playNextMatch) {
        this.playNextMatch = playNextMatch;
        this.gotInput = true;
    }

    public boolean isPlayerTurnDone() {
        return playerTurnDone;
    }

    public void setPlayerTurnDone(boolean playerTurnDone) {
        this.playerTurnDone = playerTurnDone;
        this.gotInput = true;
    }

    public boolean getGotInput(){
        return this.gotInput;
    }
    //endregion
}
