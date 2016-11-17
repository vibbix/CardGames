package edu.wit.comp2000.group25.lists;
import java.util.Scanner;



/**
 * Created by Mark on 11/15/2016.
 */
public class Game {
	public static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		int money = 1000; //starting w 1000 for now
		int bet = 0;
		System.out.println("Welcome to Blackjack");
		System.out.println("You have " + money + " dollars");
		System.out.println("How much would you like to bet?");
		bet = input.nextInt();
		
		if (bet < 0 || bet > money){
			System.out.println("Bet must be between 0 and " + money + ".");
			System.out.println("Please enter again");
			bet= input.nextInt();
		}
		
		playGame();
		
		
	}
	
	static boolean playGame(){
		Deck deck;
		Hand playerHand;
		Hand dealerHand;
		
		deck = new Deck();
		playerHand = new Hand();
		dealerHand = new Hand();
		
		//shuffle deck <-- dont know where to get this from
		//playerHand.deal();
		//add card to player
		//add card to dealer 
		//add card to player
		//add card to dealer in the hole
		
		
	//	Chack if Dealer has ace
	/*	if (dealerHand.Cardgetvalue() == 1) {
	        System.out.println("Dealer has the " + dealerHand.//get card + " and the " + dealerHand.//get card + ".");
	        System.out.println("User has the " + userHand.//get card + " and the " + userHand.//get card + ".");
	        System.out.println();
	        System.out.println("Dealer has an Ace. Would you like to play insurance");
	        return false;
	
	 */
		
		//check if someone has blackjack
	/*	if (dealerHand.(getcardvaluemethod == 21) {
	        System.out.println("Dealer has the " + dealerHand.//method to get card + " and the " + dealerHand.//get card + ".");
	        System.out.println("User has the " + userHand.//get card + " and the " + userHand.//get card + ".");
	        System.out.println();
	        System.out.println("Dealer has Blackjack.  Dealer wins.");
	        return false;
	  }
		if (userHand.getcardcaluemethod == 21) {
	        System.out.println("Dealer has the " + dealerHand.//method to get card + " and the " + dealerHand.//get card + ".");
	        System.out.println("User has the " + userHand.//get card  + " and the " + userHand.//get card + ".");
	        System.out.println();
	        System.out.println("You have Blackjack.  You win.");
	        return true;
	        }
	   }
	   
	*/ //Gives player turns
		while (true){
		System.out.print("Your hand consists of : " + playerHand.getSoftHandValues() + "" + playerHand.getSuite());
		System.out.print("Your total is : " + dealerHand.getSoftHandValues());
		System.out.println("Would you like to hit, stand, double down. or split");
		//need to change tht print when user cant split^
		String nextMove;
		do {
	           nextMove = input.nextLine();
	           if (nextMove != "Hit" && nextMove != "Stand" && nextMove != "Double" && nextMove != "Split"){
	              System.out.println("Please respond Hit, Stand, Double, or Split:  ");
	        	  //System.out.println("Please respond with a move");
	           }
		} while (nextMove != "Hit" && nextMove != "Stand" && nextMove != "Double" && nextMove != "Split");
		if (nextMove == "Hit"){
			System.out.println("User hits");
			//give player another card
		}
		if (nextMove == "Stand"){
			System.out.println("User stands");
			break;
		}
		if (nextMove == "Double"){
			//double bet
			//give another card
			//dealer plays
		}
		if (nextMove == "Split"){
			
		}
		
	
		return false;
		}
	}
	
	
	
	//only put this in a method for organization
	//could be a boolean 
	static void playerWin(){
		if (userHand.getValue == 21){
			System.out.println("You hit blackjack!");
			money = bet + ((bet * 3) / 2);
		}
		else{
			System.out.println("You win the hand!");
			money = bet * 2;
		}
		System.out.println("Your balance is now " + money + "dollars");
		System.out.println("would you like to play again?");
	}
	
	private int tests(){
		//stub
		return 0;
	}
}
