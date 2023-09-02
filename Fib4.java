import java.util.*;
import java.math.*;
class Fib4
{
	public static void fibnacci(BigInteger f1, BigInteger f2, BigInteger temp, int n)
	{
		if(n>=0)
		{
			System.out.print(f1+" ");
			temp = f1.add(f2);
			f1 = f2;
			f2 = temp;
			n--;
			fibnacci(f1, f2, temp, n);
		}
	}
	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		fibnacci(new BigInteger("0"),new BigInteger("1"),new BigInteger("0"),n);
	}
}