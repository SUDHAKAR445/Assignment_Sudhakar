import java.util.*;
public class Hello
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int fib1 = -1, fib2 = 1;
		System.out.println("Enter the Number : \n");
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println(fib1+fib2);
			int t = fib1 + fib2;
			fib1 = fib2;
			fib2 = t;
		}
	}
}