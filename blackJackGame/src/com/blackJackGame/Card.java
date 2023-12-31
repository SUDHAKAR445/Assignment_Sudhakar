package com.blackJackGame;

interface CardInterface
{
	Suit getSuit();
	Rank getRank();
	String toString();
}
public class Card 
{
	// Each card have suit and rank, so we create the rank and suit  of type of Rank and Suit
	
	private Rank rank;
	private Suit suit;
	
	// Set the values for rank and suit variable 
	
	public Card(Suit suit, Rank rank)
	{
		this.suit = suit;
		this.rank = rank;
	}

	//getters are used to get the suit,rank and value 
	public Suit getSuit() 
	{
		return suit;
	}
	
	public Rank getRank() 
	{
		return rank;
	}
	
	
	public int getValue()
	{
		return rank.rankValue;
	}
	
	public Card(Card card)
	{
		this.suit = card.getSuit();
		this.rank = card.getRank();
	}
	// we need to return suit,rank and value all together. So,we use the toString method
	
	public String toString()
	{
		return ("["+rank+" of "+suit + "] "+this.getValue());
	}
}
