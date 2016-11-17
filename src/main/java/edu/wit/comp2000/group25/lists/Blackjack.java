package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Collections.Deck;
import edu.wit.comp2000.group25.lists.Enums.CardValue;
import edu.wit.comp2000.group25.lists.Enums.GameState;
import edu.wit.comp2000.group25.lists.Enums.PlayerMoves;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.PrintStream;

/**
 * The game class
 */
public class Blackjack {
    private Deck deck;
    private GameState gs;
    private Dealer dealer;
    private Player player;
    private PrintStream out;
    private int matchnum;
    private int playerWager;
    private PlayerBank playerBank;
    private DealerBank dealerBank;

    /**
     * Creates a new game
     *
     * @param decks       Numbers of decks to play with (at least 1 deck)
     * @param dealerMoney Amount dealer starts with (at least $100, or $0 for unlimited)
     * @param playerMoney Amount player starts with (at least $100)
     * @param out         PrintStream to output to (i.e System.out)
     * @throws IllegalArgumentException
     */
    public Blackjack(int decks, int dealerMoney, int playerMoney, PrintStream out) {
        if (decks < 1) {
            throw new IllegalArgumentException("Must have at least 1 deck.");
        }
        if (dealerMoney < 100) {
            throw new IllegalArgumentException("Dealer must have at least $100");
        }
        if (playerMoney < 100) {
            throw new IllegalArgumentException("Player must have at least $100");
        }
        this.out = out;
        this.deck = new Deck(decks);
        this.gs = GameState.GameBegin;
        this.dealer = new Dealer();
        if (dealerMoney == 0) {
            this.dealerBank = new DealerBank();
        } else {
            this.dealerBank = new DealerBank(dealerMoney);
        }
        this.playerBank = new PlayerBank(playerMoney);
    }

    /**
     * Executes the next phase in the game, returning true
     * when
     *
     * @return True is successfully transitioned
     */
    public boolean nextPhase() {
        switch (this.gs) {
            case GameBegin:
                return this.gsGameBegin();
            case PlayerWantsToStartMatch:
                return this.gsPlayerWantsToStartMatch();
            case CanStartNewMatch:
                return this.gsCanStartNewMatch();
            case NewMatch:
                return this.gsNewMatch();
            case PlayersPlaceWagers:
                return this.gsPlayersPlaceWagers();
            case DealerPlacesPlayerCards:
                return this.gsDealerPlacesPlayerCards();
            case DealerGivesSelfCards:
                return this.gsDealerGivesSelfCards();
            case DealerCheckForAce:
                return this.gsDealerCheckForAce();
            case PlayersPlaceInsurance:
                return this.gsPlayersPlaceInsurance();
            case DealerCheckInsurance:
                return this.gsDealerCheckInsurance();
            case PlayerTurn:
                return this.gsPlayerTurn();
            case DealerFlipCard:
                return this.gsDealerFlipCard();
            case DealerHit:
                return this.gsDealerHit();
            case DealerDistributeWinnings:
                return this.gsDealerDistributeWinnings();
            case MatchEnd:
                return this.gsMatchEnd();
            case GameEnd:
                return this.gsGameEnd();
        }
        return false;
    }

    //region GameStates
    private boolean gsGameBegin() {
        throw new NotImplementedException();
    }

    private boolean gsPlayerWantsToStartMatch() {
        throw new NotImplementedException();
    }

    private boolean gsCanStartNewMatch() {
        throw new NotImplementedException();
    }

    private boolean gsNewMatch() {
        throw new NotImplementedException();
    }

    private boolean gsPlayersPlaceWagers() {
        throw new NotImplementedException();
    }

    private boolean gsDealerPlacesPlayerCards() {
        for (int i = 0; i < 2; i++)
            this.player.hit();
        this.gs = GameState.DealerGivesSelfCards;
        return true;
    }

    private boolean gsDealerGivesSelfCards() {
        for (int i = 0; i < 2; i++)
            this.dealerHit();
        this.gs = GameState.DealerCheckForAce;
        return true;
    }

    private boolean gsDealerCheckForAce() {
        if (this.dealer.getCards()[0].getValue() == CardValue.Ace) {
            this.gs = GameState.PlayersPlaceInsurance;
            return true;
        } else {
            this.gs = GameState.PlayerTurn;
            return true;
        }
    }

    private boolean gsPlayersPlaceInsurance() {
        throw new NotImplementedException();
    }

    private boolean gsDealerCheckInsurance() {
        throw new NotImplementedException();
    }

    private boolean gsPlayerTurn() {
        throw new NotImplementedException();
    }

    private boolean gsDealerFlipCard() {
        throw new NotImplementedException();
    }

    private boolean gsDealerHit() {
        throw new NotImplementedException();
    }

    private boolean gsDealerDistributeWinnings() {
        throw new NotImplementedException();
    }

    private boolean gsMatchEnd() {
        throw new NotImplementedException();
    }

    private boolean gsGameEnd() {
        throw new NotImplementedException();
    }


    //endregion
    //region Helper methods
    private void dealerHit() {
        this.dealer.hitDeck(this.deck);
    }

    private PlayerMoves[] getPossiblePlayerMoves() {
        throw new NotImplementedException();
    }

    /**
     * Starts a new match
     */
    public void newMatch() {
        this.gs = GameState.NewMatch;
        matchnum++;
    }

    /**
     * Gets the current state of the game
     *
     * @return The current state
     */
    //endregion
    public GameState getGameState() {
        return this.gs;
    }

    /**
     * Gets the game player
     *
     * @return The player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * @return The card dealer
     */
    public Dealer getDealer() {
        return this.dealer;
    }

    /**
     * Gets the players bank
     *
     * @return The player bank
     */
    public PlayerBank getPlayerBank() {
        return this.playerBank;
    }

    /**
     * Gets the dealers bank
     *
     * @return The dealers bank
     */
    public DealerBank getDealerBank() {
        return this.dealerBank;
    }


}
