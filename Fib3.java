class Fib3
{
	public static void fibnacci(long f1, long f2, long temp, int n)
	{
		if(n!=0)
		{
			System.out.print(f1+" ");
			temp = f1+f2;
			f1 = f2;
			f2 = temp;
			n--;
			fibnacci(f1, f2, temp, n);
		}
	}
	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		fibnacci(0,1,0,n);
	}
}