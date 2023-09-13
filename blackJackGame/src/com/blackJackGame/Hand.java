package com.blackJackGame;
import java.util.ArrayList;

interface HandInterface
{
	void takeCardFromDeck(Deck deck);
	Card getCard(int index);
	int calculatedValue();
	String toString();
	void discardHandToDeck(Deck discardDeck);
}
public class Hand implements HandInterface
{
	// used to manage an cards(ArrayList)
	private ArrayList<Card> hand;
	public Hand()
	{
		hand = new ArrayList<Card>();
	}
	
	// method to add a card from a deck to this hand
	public void takeCardFromDeck(Deck deck)
	{
		hand.add(deck.takeCard());
	}
	
	// Calculate the total in the hand 
	// Ace value is 1 or 11 depending on the situation 
	// four ace is evaluated as 11 + 1 + 1 + 1 = 14
	// Jack, Queen,and King value is 10 
	
	public Card getCard(int index)
	{
		return hand.get(index);
	}
	//Time complexity = O(n)
	//Space complexity = O(1)
	public int calculatedValue()
	{
		int value = 0;
		int aceCount = 0; // we need to track the ace count because it value depends on situation in the calculation
		for(Card card : hand)
		{
			value += card.getValue();
			if(card.getValue() == 11)
			{
				aceCount++;
			}
		}
		if(value > 21 && aceCount >0)
		{
			while(aceCount>0 && value >21)
			{
				aceCount--;
				value -= 10;
			}
		}
		return value;
	}
	// toString() method to printing the dealer or the player's current head
	//Time complexity = O(n)
	//Space complexity = O(1)
	public String toString()
	{
		String output = "";
		for(Card card : hand)
		{
			output += card + " - ";
		}
		return output;
	}
	public void discardHandToDeck(Deck discardDeck){

	    //copy cards from hand to discardDeck
	    discardDeck.addCards(hand);

	    //clear the hand
	    hand.clear();

	}
}
