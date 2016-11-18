package edu.wit.comp2000.group25.lists;

import edu.wit.comp2000.group25.lists.Collections.Hand;
import edu.wit.comp2000.group25.lists.Enums.PlayerMoves;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The main method
 */
public class Game {
    private final static String STR_DECKS = "Decks to play with(Suggested: 4-8): ";
    private final static String STR_PLAYERMONEY = "Money for player to start with: ";
    private final static String STR_DEALERMONEY = "Money for dealer to start with (0 for unlimited): ";
    private Blackjack blackjack;
    private Scanner scanner;
    private PrintStream out;

    /**
     * Creates a new instance of the game class
     *
     * @param ps          PrintStream to output to(i.e. System.out)
     * @param in          InputStream to use (i.e. System.in)
     * @param playDecks   Number of decks to play with (Min. 1)
     * @param dealerMoney Amount of money dealer starts with (0 for infinity, otherwise start at $100)
     * @param playerMoney Amount of money player starts with (Min. 100)
     */
    public Game(PrintStream ps, InputStream in, int playDecks, int dealerMoney, int playerMoney) {
        this.out = ps;
        this.scanner = new Scanner(in);
        this.blackjack = new Blackjack(playDecks, dealerMoney, playerMoney, ps);
    }

    /**
     * @param out Printstream to output to (i.e. System.out)
     * @param in  InputStream to take input from (i.e. System.in)
     */
    public Game(PrintStream out, InputStream in) {
        this.out = out;
        this.scanner = new Scanner(in);
        this.initializeGame();
    }

    public static void main(String[] args) {
        Game m = new Game(System.out, System.in);
        m.startGame();
    }

    private void initializeGame() {
        int decks = this.getInt(STR_DECKS, 1);
        int playermoney = this.getInt(STR_PLAYERMONEY, 100);
        int dealermoney = this.getInt(STR_DEALERMONEY, 0);
        while (true) {
            if(dealermoney == 0)
                break;
            else if (dealermoney < 100) {
                this.out.println("Dealer must have at least $100");
                dealermoney = this.getInt(STR_DEALERMONEY, 0);
                continue;
            }
            break;
        }
        this.blackjack = new Blackjack(decks, dealermoney, playermoney, this.out);

    }

    public void startGame() {
        while (true) {
            if (this.blackjack.getGameState().getIsPlayerPhase()) {
                switch (this.blackjack.getGameState()) {
                    case PlayerWantsToStartMatch:
                        if (!this.playerWantsToStartMatch()) {
                            this.blackjack.getPlayerInput().setPlayNextMatch(false);
                            break;
                        }
                        this.blackjack.getPlayerInput().setPlayNextMatch(true);
                        break;
                    case PlayersPlaceWagers:
                        int wager = this.playerPlaceWagers();
                        this.blackjack.getPlayerInput().setCurrentWager(wager, 0);
                        break;
                    case PlayersPlaceInsurance:
                        int insurance = this.playersPlaceInsurance();
                        this.blackjack.getPlayerInput().setCurrentInsurance(insurance);
                        break;
                    case PlayerTurn:
                        this.playerTurn();
                        this.blackjack.getPlayerInput().setPlayerTurnDone(true);
                        break;
                    case GameEnd:
                        this.gameEnd();
                        return;
                }
            }
            this.blackjack.nextPhase();
        }
    }

    private int playerPlaceWagers() {
        int wager = 0;
        while (true) {
            wager = getInt("Amount to wager for this round: ", 1);
            if (wager > this.blackjack.getPlayerBank().getMoney()) {
                this.out.println("You only have $" + this.blackjack.getPlayerBank().getMoney());
                continue;
            }
            break;
        }
        return wager;
    }

    private boolean playerWantsToStartMatch() {
        while (true) {
            this.out.print("Do you want to start the match? (Y/N) ");
            String answer = this.scanner.next().toLowerCase().trim();
            switch (answer) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    this.out.println("Not a valid answer, try again.");
                    break;
            }
        }
    }

    private void playerTurn() {
        Player p = this.blackjack.getPlayer();
        while (true) {
            //if already busted

            this.out.println("------------------------");
            this.out.println("Dealer hand: " +
                    Arrays.toString(this.blackjack.getDealer().getCards()));
            this.out.println("Player hand: " +
                    Arrays.toString(this.blackjack.getPlayer().getHands()));
            this.out.println("Amount left in users bank: $" + (
                    this.blackjack.getPlayerBank().getMoney() - this.blackjack.getPlayerInput().getTotalAmountBet()));
            if(Arrays.stream(p.getHands()).allMatch(Hand::hasBusted)){
                this.out.println("Player has busted.");
                return;
            }
            //this.out.println("Available Moves: " + Arrays.toString(p.getAvailableMoves(0)));
            this.out.println("Available Moves: Surrender, Hit, Double, Split, Stand");
            this.out.println("Entering 'Stand' will end your turn.");
            this.out.print("Move: ");
            String next = this.scanner.next();
            try{
                PlayerMoves pm = PlayerMoves.valueOf(next);
                int index = 0;
                if(p.hasSplit()){
                    index = this.getInt("Which hand would you like to perform that action on?: (0->3) ", 0);
                }
                //if any of the hands have not busted
                if(Arrays.stream(p.getHands()).anyMatch(Hand::hasBusted))
                {
                    if(p.getHands()[index].hasBusted()){
                        this.out.println("This hand has busted.");
                        continue;
                    }
                }
                if(pm == PlayerMoves.Hit){
                    p.hit(index);
                }
                if(pm == PlayerMoves.Double){
                    int wager = this.getInt("Amount to bet on: $", 0);
                    p.doubleDown(wager, index);
                }
                if(pm == PlayerMoves.Split){
                    int wager = this.getInt("Amount to bet on: $", 0);
                    p.split(wager, index);
                }
                if(pm == PlayerMoves.Surrender){
                    p.surrender(0);
                }
                if(pm == PlayerMoves.Stand){
                    return;
                }
            }catch (Exception ex){
                this.out.println("Error running command: " + ex.toString());
            }
        }
    }

    private int playersPlaceInsurance() {
        int insurance = 0;
        while (true) {
            insurance = getInt("Amount to set insurance sidebet: ", 0);
            if (insurance > this.blackjack.getPlayerBank().getMoney()) {
                this.out.println("You only have $" + this.blackjack.getPlayerBank().getMoney());
                continue;
            }
            break;
        }
        return insurance;
    }

    private void gameEnd() {
        this.out.println("Thank you for playing!");
    }

    /**
     * Gets an integer from the user.
     *
     * @param question The prompt to ask the user
     * @param min      The minimum the response can be
     * @return The number of decks the player wants to play with
     */
    private int getInt(String question, int min) {
        while (true) {
            try {
                this.out.print(question);
                int num = this.scanner.nextInt();
                if (num < min) {
                    this.out.println("Integer must be at least " + min + ".");
                    continue;
                }
                return num;
            } catch (Exception ex) {
                this.out.print("Error parsing int.");
            }
        }
    }

}
