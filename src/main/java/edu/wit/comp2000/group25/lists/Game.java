package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Collections.Deck;
import edu.wit.comp2000.group25.lists.Enums.GameState;

/**
 * The game class
 */
public class Game {
    private Deck deck;
    private GameState gs;
    private Dealer dealer;
    private Player player;
    private int matchnum;
    private int playerWager;
    private PlayerBank playerBank;
    private DealerBank dealerBank;
    /**
     * Creates a new game
     *
     * @param decks Numbers of decks to play with
     */
    public Game(int decks, int dealermoney, int playermoney) {
        this.deck = new Deck(decks);
        this.gs = GameState.Initialize;
        this.dealer = new Dealer();
        if(dealermoney == 0)
            this.dealerBank = new DealerBank();
        else
            this.dealerBank = new DealerBank(playermoney);
        this.playerBank = new PlayerBank(playermoney);
    }

    /**
     * Starts a new match
     */
    public void newMatch() {
        this.gs = GameState.Initialize;
        matchnum++;
    }

    /**
     * Executes the next phase in the game, returning whether
     * the next phase requires user input. If the phase is not
     * complete, then it will wait until
     *
     *
     * @return True if the next phase requires use input
     */
    public boolean nextPhase() {
        switch (this.gs) {
            case Initialize:
                return this.gsInitialize();
            case PlayersPlaceWagers:
                break;
            case DealerPlacesPlayerCards:
                return this.gsDealerPlacesPlayerCards();
            case DealerGivesSelfCards:
                return this.gsDealerGivesSelfCards();
            case DealerCheckForAce:
                break;
            case DealerAsksForInsurance:
                break;
            case DealerCheckInsurance:
                break;
            case PlayerTurn:
                break;
            case DealerFlipCard:
                break;
            case DealerDistributeWinnings:
                break;
            case GameEnd:
                break;
        }
        return false;
    }



    //region GameStates
    private boolean gsInitialize(){
        return false;
    }
    private boolean gsDealerPlacesPlayerCards(){
        for(int i = 0; i < 2; i++)
            this.player.hit();
        this.gs = GameState.DealerGivesSelfCards;
        return false;
    }
    private boolean gsDealerGivesSelfCards(){
        for(int i = 0; i < 2; i++)
            this.dealerHit();
        this.gs = GameState.DealerCheckForAce;
        return false;
    }


    //endregion
    //region Helper methods
    private void dealerHit() {
        this.dealer.hitDeck(this.deck);
    }
    //endregion


}
