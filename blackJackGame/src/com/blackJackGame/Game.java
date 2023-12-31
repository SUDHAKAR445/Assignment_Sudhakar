package com.blackJackGame;

public class Game
{
	static int wins; // used to store the scores
	static int losses;
	static int pushes;
	private Deck deck , discarded;
	private Dealer dealer;
	private Player player;
	
	public Game()
	{
		/*
		 * // Whenever start our game we need set our instance variable to zero wins =
		 * 0; losses = 0; pushes = 0;
		 */
		// Create a new Deck with 52 cards
		
		deck = new Deck(true);
		
		// Create a new empty deck
		
		discarded = new Deck();
		
		// Create the people
		
		dealer = new Dealer();
		player = new Player();
		
		deck.shuffle();
		startRound();
	}
	
	private void startRound() {

		       if(wins>0 || losses>0 || pushes > 0){
		           System.out.println();
		           System.out.println("Starting Next Round... Wins: " + wins + " Losses: "+ losses+ " Pushes: "+pushes);
		           dealer.getHand().discardHandToDeck(discarded);
		           player.getHand().discardHandToDeck(discarded);
		       }

		       //Check to make sure the deck has at least 4 cards left
		       if(deck.cardsLeft() < 4){
		           deck.reloadDeckFromDiscard(discarded);
		       }

		       //Give the dealer two cards
		       dealer.getHand().takeCardFromDeck(deck);
		       dealer.getHand().takeCardFromDeck(deck);

		       //Give the player two cards
		       player.getHand().takeCardFromDeck(deck);
		       player.getHand().takeCardFromDeck(deck);

		       //Print their hands
		       dealer.printFirstHand();
		       player.printHand();

		       //Check if dealer has BlackJack to start
		       if(dealer.hasBlackjack()){
		           //Show the dealer has BlackJack
		           dealer.printHand();

		           //Check if the player also has BlackJack
		           if(player.hasBlackjack()){
		               //End the round with a push
		               System.out.println("You both have 21 - Push.");
		               pushes++;
		               startRound();
		           }
		           else{
		               System.out.println("Dealer has BlackJack. You lose.");
		               dealer.printHand();
		               losses++;
		               startRound();
		           }
		       }

		       //Check if player has blackjack to start
		       //If we got to this point, we already know the dealer didn't have blackjack
		       if(player.hasBlackjack()){
		           System.out.println("You have Blackjack! You win!");
		           wins++;
		           startRound();
		       }

		       //Let the player decide what to do next
		       player.makeDecision(deck, discarded);

		       //Check if they busted
		       if(player.getHand().calculatedValue() > 21){
		           System.out.println("You have gone over 21.");
		           //count the losses
		           losses ++;
		           //start the round over
		           startRound();
		       }

		       //Now it's the dealer's turn
		       dealer.printHand();
		       while(dealer.getHand().calculatedValue()<17){
		           dealer.hit(deck, discarded);
		       }

		       //Check who wins
		       if(dealer.getHand().calculatedValue()>21){
		           System.out.println("Dealer busts");
		           wins++;
		       }
		       else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
		           System.out.println("You lose.");
		           losses++;
		       }
		       else if(player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
		           System.out.println("You win.");
		           wins++;
		       }
		       else{
		           System.out.println("Push.");
		       }

		       //Start a new round
		       startRound();
	}
}
