package com.blackJackGame;

public abstract class Person 
{
	private String name ;
	private Hand hand;
	
	public Person() {
		this.hand = new Hand();
		this.name = "";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hand getHand() {
		return hand;
	}
	public void setHand(Hand hand) {
		this.hand = hand;
	}
		
	public void printHand()
	 {
	    System.out.println(this.name + "'s hand looks like this:");
	    System.out.println(this.hand + " Valued at: " + this.hand.calculatedValue());
	}
	
	public boolean hasBlackjack()
	{
		if(this.getHand().calculatedValue() == 21)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void hit(Deck deck, Deck discard){

	    //If there's no cards left in the deck
	    if (!deck.hasCards()) {
	        deck.reloadDeckFromDiscard(discard);
	    }
	    this.hand.takeCardFromDeck(deck);
	    System.out.println(this.name + " gets a card");
	    this.printHand();

	}
}
