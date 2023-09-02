/*import java.util.*;
public class ButterflyPattern
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value for n : ");
		int n = sc.nextInt();
		int space = 2*n-1;
		int pattern = 0;
		for(int i =1; i<=2*n-1;i++)
		{
			if(i<=n)
			{
				space -= 2;
				pattern++;
			}
			else
			{
				space +=2;
				pattern--;
			}
			for(int j=1; j<=pattern; j++)
			{
				System.out.print("*");
			}
			for(int k=1; k<=space;k++)
			{
				System.out.print(" ");
			}
			for(int l=1; l<=pattern; l++)
			{
				if(l!=n)
				{
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}*/
// Butterfly Pattern in Java of Numbers using For loop
import java.util.Scanner;

public class ButterflyPattern {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rows, height,space;

        System.out.print("Enter the height of the pattern: ");
        height = in.nextInt();
        for(rows = 1; rows <= height - 1; rows++) 
		{
            for(int i = 1; i <= rows; i++)
                System.out.print("*");
            for(int j = 1; j <= 2 * (height - rows); j++)
                System.out.print(" ");
            System.out.print('\b');
            for(int k = rows; k >= 1; k--)
                System.out.print("*");
            System.out.print('\n');
        }

        for(rows = height; rows >= 1; rows--) 
		{
            for(int i = 1; i <= rows; i++)
                System.out.print("*");
            for(int j = 1; j <= 2 * (height - rows); j++)
                System.out.print(" ");
            System.out.print('\b');
            for(int k = rows; k >= 1; k--)
                System.out.print("*");
            System.out.print('\n');
        }
    }
}