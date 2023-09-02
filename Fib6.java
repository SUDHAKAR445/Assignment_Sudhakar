import java.util.*;
import java.math.*;
class Fib6
{ 
	static BigInteger fib1 = new BigInteger("0");
	static BigInteger fib2 = new BigInteger("0");
	public static void fibnacci(BigInteger f1, BigInteger f2, int n)
	{
		if(n!=0)
		{
			System.out.print(f1+" ");
			BigInteger temp = f1.add(f2);
			f1 = f2;
			f2 = temp;
			n--;
			fibnacci(f1, f2, n);
		}
		else
		{
			fib1 = f1;
			fib2 = f2;
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the n value : ");
		int n = sc.nextInt();
		fibnacci(new BigInteger("0"),new BigInteger("1"),n);
		int choice=0;
		while(choice!=1)
		{
			System.out.println("Enter the choice : 0 - continue 1- exit ");
			choice = sc.nextInt();

			switch(choice)
			{
				case 0:
				{
					System.out.println("Enter the n value : ");
					n = sc.nextInt();
					fibnacci(fib1,fib2,n);
					break;
				}
				case 1:
					break;
				default:
					System.out.println("Enter the valid choice!");
			}
			System.out.println();
		}
	}
}