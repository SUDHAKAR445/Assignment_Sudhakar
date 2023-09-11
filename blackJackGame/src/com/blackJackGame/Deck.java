package com.blackJackGame;
import java.util.*;
public class Deck 
{
	private ArrayList<Card> deck;// deck will be used to manage an Cards(ArrayList)
	public Deck()
	{
		deck = new ArrayList<Card>();
	}
	public Deck(Deck c){
        Collections.copy(this.deck, c.getCards());
    }
	// Adding card to the deck
	public void addCard(Card card)
	{
		deck.add(card);
	}
		
	//adding all the 52 cards  in deck
	
	public Deck(boolean makeDeck)
	{
		deck = new ArrayList<Card>();
		for(Suit suit : Suit.values())
		{
			for(Rank rank : Rank.values())
			{
				deck.add(new Card(suit, rank));
			}
		}
	}
	
	// Now shuffle the cards in the deck
	
	public void shuffle()
	{
		ArrayList<Card> shuffled = new ArrayList<Card>();
		while(deck.size()>0)
		{
			//generate random index number using Math.random() method
			int index = (int)(Math.random()*(deck.size()-1));
			//add that index element to shuffled deck
			shuffled.add(deck.get(index));
			// remove that add element in deck which is added to shuffled deck
			deck.remove(index);
		}
		// assigned the shuffled deck to the deck
		deck = shuffled;
	}
	
	// method to take card from the deck
	public Card takeCard()
	{
		// take first card from the deck and remove that card from the deck
		Card cardToTake = new Card(deck.get(0));
		deck.remove(0);
		
		return cardToTake;
	}
	public String toString()
	{
		String output = "";
		
		for(Card card : deck)
		{
			output += card;
			output +="\n";
		}
		return output;
	}
	public boolean hasCards(){
	    if (deck.size()>0){
	        return true;
	    }
	    else{
	        return false;
	    }
	}
	
	// used to find the how many cards left in the deck because we need at least four cards to play
	public int cardsLeft(){
        return deck.size();
    }
	
	// it is used to empty the discard deck after finishing all the cards in the deck 
	public void emptyDeck(){
	    deck.clear();
	}
	public ArrayList<Card> getCards() {
	    return deck;
	}
	
	// 
	public void addCards(ArrayList<Card> cards){
	    deck.addAll(cards);
	}
	
	// it is used to reload all the card from discard deck to deck  and empty the discard deck
	public void reloadDeckFromDiscard(Deck discard){
	    this.addCards(discard.getCards());
	    this.shuffle();
	    discard.emptyDeck();
	}
}
