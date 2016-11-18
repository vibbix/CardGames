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
    private PlayerInput playerInput;

    /**
     * Creates a new game
     *
     * @param decks       Numbers of decks to play with (at least 1 deck)
     * @param dealerMoney Amount dealer starts with (at least $100, or $0 for unlimited)
     * @param playerMoney Amount player starts with (at least $100)
     * @param out         PrintStream to output to (i.e System.out)
     * @throws IllegalArgumentException Thrown if arguments are invalid
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
        this.dealer = new Dealer(this);
        this.player = new Player(this);
        this.dealerBank = (dealerMoney == 0 ? new DealerBank() : new DealerBank(dealerMoney));
        this.playerInput = new PlayerInput();
        this.playerBank = new PlayerBank(playerMoney);
        this.matchnum = 0;
    }

    /**
     * Executes the next phase in the game, returning true
     * if the state successfully transitioned
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
                return this.gsPlayerPlaceWagers();
            case DealerPlacesPlayerCards:
                return this.gsDealerPlacesPlayerCards();
            case DealerGivesSelfCards:
                return this.gsDealerGivesSelfCards();
            case DealerCheckForAce:
                return this.gsDealerCheckForAce();
            case PlayersPlaceInsurance:
                return this.gsPlayerPlaceInsurance();
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
        this.gs = GameState.CanStartNewMatch;
        return true;
    }

    private boolean gsPlayerWantsToStartMatch() {
        if (this.playerInput.getGotInput()) {
            if (this.playerInput.isPlayNextMatch()) {
                this.gs = GameState.CanStartNewMatch;
            } else {
                this.gs = GameState.GameEnd;
            }
            return true;
        }
        return false;
    }

    private boolean gsCanStartNewMatch() {
        if (this.playerBank.getMoney() < 1) {
            this.out.println("Player is bankrupt. Game over.");
            this.gs = GameState.GameEnd;
            return true;
        }
        if (!this.dealerBank.isInfinite() && this.dealerBank.getMoney() < 1) {
            this.out.println("Dealer is bankrupt. Game over.");
            this.gs = GameState.GameEnd;
            return true;
        }
        if (this.dealer.getCards().length < 5) {
            this.out.println("Dealer ran out of cards. Game Over.");
            this.gs = GameState.GameEnd;
            return true;
        }
        this.gs = GameState.NewMatch;
        matchnum++;
        return true;

    }

    private boolean gsNewMatch() {
        //reset player input
        this.playerInput = new PlayerInput();
        this.gs = GameState.PlayersPlaceWagers;
        return true;
    }

    private boolean gsPlayerPlaceWagers() {
        if (this.playerInput.getGotInput()) {
            if (this.playerInput.getTotalAmountBet(0) > 1) {
                this.gs = GameState.DealerPlacesPlayerCards;
                return true;
            }
        }
        return false;
    }

    private boolean gsDealerPlacesPlayerCards() {
        for (int i = 0; i < 2; i++)
            this.player.hit();
        this.gs = GameState.DealerGivesSelfCards;
        return true;
    }

    private boolean gsDealerGivesSelfCards() {
        for (int i = 0; i < 2; i++)
            this.dealer.hitDeck();
        this.gs = GameState.DealerCheckForAce;
        return true;
    }

    private boolean gsDealerCheckForAce() {
        if (this.dealer.getCards()[0].getValue() == CardValue.Ace) {
            this.gs = GameState.PlayersPlaceInsurance;
            return true;
        }
        this.gs = GameState.PlayerTurn;
        return true;
    }

    private boolean gsPlayerPlaceInsurance() {
        if (this.playerInput.getCurrentInsurance() > -1) {
            this.gs = GameState.DealerCheckInsurance;
            return true;
        }
        return false;
    }

    private boolean gsDealerCheckInsurance() {
        if (this.dealer.hasBlackjack()) {
            this.gs = GameState.DealerDistributeWinnings;
            return true;
        }
        this.gs = GameState.PlayerTurn;
        return true;
    }

    private boolean gsPlayerTurn() {
        if (this.playerInput.isPlayerTurnDone()) {
            this.gs = GameState.DealerFlipCard;
            return true;
        }
        return false;
    }

    private boolean gsDealerFlipCard() {
        this.dealer.revealCards();
        if (this.dealer.mustHit()) {
            this.gs = GameState.DealerHit;
        } else {
            this.gs = GameState.DealerDistributeWinnings;
        }
        return true;

    }

    private boolean gsDealerHit() {
        this.dealer.hitDeck();
        if (this.dealer.mustHit()) {
            return true;
        }
        this.gs = GameState.DealerDistributeWinnings;
        return true;
    }

    private boolean gsDealerDistributeWinnings() {
        //check insurance
        if (this.playerInput.getCurrentInsurance() > -1) {
            if (this.dealer.hasBlackjack()) {
                this.dealerBank.transferTo(this.playerBank, 2 * this.playerInput.getCurrentInsurance());
            } else {
                this.playerBank.transferTo(this.dealerBank, this.playerInput.getCurrentInsurance());
            }
        }
        //
        //Hand[] playerHands = this.player
        return false;
    }

    private boolean gsMatchEnd() {
        this.gs = GameState.PlayerWantsToStartMatch;
        return true;
    }

    private boolean gsGameEnd() {
        return false;
    }

    //endregion
    //region Helper methods

    private PlayerMoves[] getPossiblePlayerMoves() {
        throw new NotImplementedException();
    }

    /**
     * Dequeues a card from the deck
     *
     * @return A card
     */
    public Card dequeueCard() {
        return this.deck.dequeueCard();
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

    public PlayerInput getPlayerInput() {
        return this.playerInput;
    }
}
