package edu.wit.comp2000.group25.lists.Enums;

/**
 * The different play modes the player can choose to play
 */
public enum PlayMode {
    /**
     * Play until either the player or dealer run out of money
     */
    UntilBankrupt,

    /**
     * Play for a set number of matches
     */
    MatchLimited,

    /**
     * Play until cards run out
     */
    UntilEndOfShoe
}
