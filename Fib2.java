class Fib2
{
	public static int fibnacci(int number)
	{
		if(number == 1)
		{
			return 0;
		}
		if(number == 2 || number == 3)
		{
			return 1;
		}
		return fibnacci(number - 1) + fibnacci(number - 2);
	}
	public static void main(String[] args)
	{
		System.out.print(fibnacci(Integer.parseInt(args[0]))+" ");
	}
}