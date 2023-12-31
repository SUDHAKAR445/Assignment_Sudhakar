package com.blackJackGame;

interface DealerInterface
{
	void printFirstHand();
}
public class Dealer extends Person implements DealerInterface
{
    public Dealer()
    {

        //Name the dealer "Dealer"
        super.setName("Dealer");

    }
    public void printFirstHand(){
        System.out.println("The dealer's hand looks like this:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down.");
    }
}