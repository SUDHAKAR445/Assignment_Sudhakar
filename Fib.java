import java.util.*;
class Fib
{
	public static int fibnacci(int number)
	{
		if(number == 0)
		{
			return 0;
		}
		if(number == 1 || number == 2)
		{
			return 1;
		}
		return fibnacci(number - 1) + fibnacci(number - 2);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Fibnacci Series :");
		for(int i=0;i<n;i++)
		{
			System.out.print(fibnacci(i)+" ");
		}
	}
}