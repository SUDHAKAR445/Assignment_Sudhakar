import java.util.*;
/*
interface Deck
{
	public char answer();
	public char flop();
	public boolean move(char x);
	public void game(int[] cards, char play);
}
*/
class BlackjackGame 
{
	static Scanner sc = new Scanner(System.in);
	
	public static void main( String[] args)
	{
		int[] deck = new int[4];
		int[] deck2 = new int[4];
		char choice;
		System.out.println(" Do you want to play blackjack game? (y/n) : ");
		choice = sc.next().charAt(0);
		game(deck, deck2, choice);
	}
	
	public static boolean move(char x)
    {
        if (x == 'y')
            return true;
	    else
            return false;
    }
	
	public static char answer()
    {
        System.out.print("\nDo you want to play again? (y/n): ");
        char next_move = sc.next().charAt(0);
        return next_move;
    }
	
	public static char flop()
    {
        System.out.print("Would you like Hit or Stand? (y/n): ");
        char a_card = sc.next().charAt(0);
        return a_card;
    }
	 
	public static void game(int[] cards, int[] dealer, char play)
	{
		char nextCard;
		int playersWins = 0, dealersWins = 0;
		
		while(move(play))
		{
			// first two cards of players
			cards[0] = (int) (Math.random() * 10) + 1;
			cards[1] = (int) (Math.random() * 10) + 1;
			
			// Cards for dealers
			dealer[0] = (int) (Math.random() * 10) + 1;
			dealer[1] = (int) (Math.random() * 10) + 1;
			
			int dealersCard = 2 , dealersTotal = 0;
			
			System.out.println("\nPlayer has won " + playersWins + " hands");
            System.out.println("Dealer has won " + dealersWins + " hands\n");
			
			dealer[3] = dealer[0] + dealer[1];
			dealersTotal = dealer[3];
			cards[3] = cards[0] + cards[1];
			
			// for one ace and one Jack or king or queen 
			
			if((cards[0] == 10 && cards[1] == 1) || (cards[0] == 1 && cards[1] == 10))
			{
				System.out.println("\n You Win!");
				playersWins +=2;
				
				play = answer();
			}
			
			if (!((cards[0] == 10 && cards[1] == 1) || (cards[0] == 1 && cards[1] == 10)))
			{
				while(true)
				{
					System.out.println(" Yow drew " + cards[0] + " and " + cards[1]);
					System.out.println(" Your Total is " + cards[3] +"\n");
					
					System.out.println(" The dealer has a "+ dealer[0] +" showing, and a hidden card.");
					System.out.println(" His total is hidden too."); 
					nextCard = flop();
					
					if(move(nextCard))
					{
						cards[2] = (int) (Math.random() * 10) + 1;
						System.out.println("\nYou drew a "+ cards[2]);
						cards[3] += cards[2];
						
						if(cards[3] > 21)
						{
							System.out.println(" Your total is " + cards[3]);
							System.out.println(" You are Bust ");
							play = answer();
							dealersWins += 1;
							break;
						}
						
						if(cards[3] == 21)
						{
							System.out.println(" Your total is " + cards[3]);
							System.out.println(" You win ");
							play = answer();
							
							playersWins += 1;
							break;
						}
					}
					if(!move(nextCard))
					{
						System.out.println("\nOkay, dealer's turn.");
						System.out.println("His hidden card is " + dealer[1]);
						System.out.println("His total is " + dealersTotal +"\n");
							
						System.out.println("Dealer choose to hit.");
						dealer[2] = (int) (Math.random() * 10 ) + 1;
						System.out.println("He draws a "+ dealer[2]);
						dealer[3] += dealer[2];
						dealersTotal = dealer[3];
						System.out.println("His total is " + dealersTotal+"\n");
						if(dealersTotal > cards[3] && dealersTotal <= 21)
						{
							System.out.println("\n Your total is " + cards[3]);
							System.out.println("\n The dealers total is " + dealersTotal +" \n Dealer win ");
							dealersWins += 1;
						}
						else if( dealersTotal > 21 || dealersTotal < cards[3])
						{
							System.out.println("\n Your total is " + cards[3]);
							System.out.println("\n The dealers total is " + dealersTotal +" \n You win ");
							playersWins += 1;
						}
						else if( dealersTotal == cards[3])
						{
							System.out.println("\n Your total is " + cards[3]);
							System.out.println("\n The dealers total is " + dealersTotal +" \n Push ");
						}
						play = answer();
						break;
					}
				}
			}
			
			if(!move(play))
			{
				System.out.println("\n Player hands won: " + playersWins);
     			System.out.println(" Dealer hands won: " + dealersWins + " \n");

     			if (playersWins > dealersWins)
     				System.out.println("Congratualations! You beat the dealer!");
     			else if (playersWins < dealersWins)
     				System.out.println("Sorry, the dealer won...");
     			else
     				System.out.println(" No winners no losers...");
			}
		}
	}
}public class FindNumber
{
	public static void main(String[] args)
	{
		final int number = 1000000;

		long sequenceLength = 0;
		long startingNumber = 0;
		long sequence;

		for (int i = 2; i <= number; i++) {
			int length = 1;
			sequence = i;
			while (sequence != 1) {
				if ((sequence % 2) == 0) {
					sequence = sequence / 2;
				} else {
					sequence = sequence * 3 + 1;
				}
				length++;
			}

			//Check if sequence is the best solution
			if (length > sequenceLength) {
				sequenceLength = length;
				startingNumber = i;
			}
		}
        System.out.println(startingNumber);
	}
}