package edu.wit.comp2000.group25.lists.Enums;

/**
 * Tracks the game state
 */
public enum GameState {
        Initialize,
        PlayersPlaceWagers,
        DealerPlacesPlayerCards,
        DealerGivesSelfCards,
        DealerCheckForAce,
        DealerAsksForInsurance,
        DealerCheckInsurance,
        PlayerTurn,
        DealerFlipCard,
        DealerDistributeWinnings,
        GameEnd
}
