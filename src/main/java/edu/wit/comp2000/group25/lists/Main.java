package edu.wit.comp2000.group25.lists;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * The main method
 */
public class Main {
    private final static String STR_DECKS = "Decks to play with(Suggested: 4-8): ";
    private final static String STR_DEALERMONEY = "Money for player to start with: ";
    private final static String STR_PLAYERMONEY = "Money for dealer to start with (0 for unlimited): ";
    private Game game;
    private Scanner scanner;
    private PrintStream out;

    /**
     * @param ps          PrintStream to output to(i.e. System.out)
     * @param in          InputStream to use (i.e. System.in)
     * @param playDecks   Number of decks to play with (Min. 1)
     * @param dealerMoney Amount of money dealer starts with (0 for infinity, otherwise start at $100)
     * @param playerMoney Amount of money player starts with (Min. 100)
     */
    public Main(PrintStream ps, InputStream in, int playDecks, int dealerMoney, int playerMoney) {
        this.out = ps;
        this.scanner = new Scanner(in);
        this.game = new Game(playDecks, dealerMoney, playerMoney, ps);
    }

    /**
     * @param out Printstream to output to (i.e. System.out)
     * @param in  InputStream to take input from (i.e. System.in)
     */
    public Main(PrintStream out, InputStream in) {
        this.out = out;
        this.scanner = new Scanner(in);
        this.initializeGame();
    }

    public static void main(String[] args) {
        Main m = new Main(System.out, System.in);
        m.startGame();
    }

    private void initializeGame() {
        int decks = this.getInt(STR_DECKS, 1);
        int playermoney = this.getInt(STR_PLAYERMONEY, 100);
        int dealermoney = this.getInt(STR_DEALERMONEY, 0);
        while (true) {
            if (dealermoney != 0 && dealermoney < 100) {
                this.out.println("Dealer must have at least $100");
                dealermoney = this.getInt(STR_DEALERMONEY, 0);
                continue;
            }
            break;
        }
        this.game = new Game(decks, dealermoney, playermoney, this.out);

    }

    public void startGame() {
        while (true) {
            if (this.game.getGameState().getIsPlayerPhase()) {
                switch (this.game.getGameState()) {
                    case PlayerWantsToStartMatch:
                        if (!this.playerWantsToStartMatch()) {
                            return;
                        }
                        break;
                    case PlayersPlaceWagers:
                        this.playerPlaceWagers();
                        break;
                    case PlayersPlaceInsurance:
                        this.playersPlaceInsurance();
                        break;
                    case PlayerTurn:
                        this.playerTurn();
                        break;
                    case GameEnd:
                        this.gameEnd();
                        return;
                }
            } else {
                this.game.nextPhase();
            }
        }
    }

    private int playerPlaceWagers() {
        throw new NotImplementedException();
    }

    private boolean playerWantsToStartMatch() {
        throw new NotImplementedException();
    }

    private void playerTurn() {
        throw new NotImplementedException();
    }

    private int playersPlaceInsurance() {
        throw new NotImplementedException();
    }

    private void gameEnd() {
        throw new NotImplementedException();
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
