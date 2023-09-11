package com.blackJackGame;
interface Interface
{
	
	Suit getSuit();
	Rank getRank();
	
	void takeCardFromDeck(Deck deck);
	Card getCard(int index);
	int calculatedValue();
	String toString();
	void discardHandToDeck(Deck discardDeck);
}
public class Main 
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to BlackJack game");
		
		// To start your game we need create a new Game object 
		
		Game blackJack = new Game();
		
	}
}
