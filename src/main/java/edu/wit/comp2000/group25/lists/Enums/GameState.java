package edu.wit.comp2000.group25.lists.Enums;

/**
 * Tracks the game state
 */
public enum GameState {
    GameBegin(false),
    PlayerWantsToStartMatch(true),
    CanStartNewMatch(false),
    NewMatch(false),
    PlayersPlaceWagers(true),
    DealerPlacesPlayerCards(false),
    DealerGivesSelfCards(false),
    DealerCheckForAce(false),
    PlayersPlaceInsurance(true),
    DealerCheckInsurance(false),
    PlayerTurn(true),
    DealerFlipCard(false),
    DealerHit(false),
    DealerDistributeWinnings(false),
    MatchEnd(false),
    GameEnd(false);
    private boolean isPlayerPhase;

    GameState(boolean isPlayerPhase) {
        this.isPlayerPhase = isPlayerPhase;
    }

    /**
     * Checks if this phase requires user input
     *
     * @return True if player does action during this phase.
     */
    public boolean getIsPlayerPhase() {
        return this.isPlayerPhase;
    }
}
