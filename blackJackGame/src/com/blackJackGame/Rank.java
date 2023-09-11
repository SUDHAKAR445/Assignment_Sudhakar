package com.blackJackGame;

public enum Rank {
	
	// Rank of cards, Name, and Value
	ACE("Ace", 11),
	TWO("Two", 2),
	THREE("Three", 3),
	FOUR("Four", 4),
	FIVE("Five", 5),
	SIX("Six", 6),
	SEVEN("Seven", 7),
	EIGHT("Eight", 8),
	NINE("Nine", 9),
	JACK("Jack", 10),
	QUEEN("Queen", 10),
	KING("King", 10);
	
	
	String rankName;
	int rankValue;
	
	// used to set the rank a name and its value
	Rank(String rankName , int rankValue)
	{
		this.rankName = rankName;
		this.rankValue = rankValue;
	}
	
	// return the rank name
	public String toString()
	{
		return rankName;
	}
}
