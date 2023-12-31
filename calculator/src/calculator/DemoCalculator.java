package calculator;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoCalculator {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Calculator cal = new CalculatorImplement();
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("0");
		int choice = 0;
		System.out.println("Calculator");
		while(choice!=6)
		{
			System.out.println("0.Continue \n1.Addition \n2.Subtraction \n3.Multiplication \n4.Division \n5.Power \n6.Exit");
			System.out.print("Enter Your Choice : ");
			choice = sc.nextInt();
			switch(choice)
			{
				case 0:
				{
					break;
				}
				case 1:
				{
					System.out.println("Enter value1 : ");
					try 
					{
						a = sc.nextBigInteger();
					}
					catch(InputMismatchException e)
					{
						System.out.println("InputMismatchException is ocuured");
					}
					System.out.println("Enter value2 : ");
					try 
					{
						b = sc.nextBigInteger();
					}
					catch(InputMismatchException e)
					{
						System.out.println("InputMismatchException is ocuured");
					}
					System.out.println("Addition value of "+a+" and "+b+" is "+ cal.add(a, b));
					break;
				}
				case 2:
				{
					try 
					{
						a = sc.nextBigInteger();
					}
					catch(InputMismatchException e)
					{
						System.out.println("InputMismatchException is ocuured");
					}
					System.out.println("Enter value2 : ");
					try 
					{
						b = sc.nextBigInteger();
					}
					catch(InputMismatchException e)
					{
						System.out.println("InputMismatchException is ocuured");
					}
					System.out.println("Subtraction value of "+a+" and "+b+" is "+ cal.subtract(a, b));
					break;
				}
				case 3:
				{
					try 
					{
						a = sc.nextBigInteger();
					}
					catch(InputMismatchException e)
					{
						System.out.println("InputMismatchException is ocuured");
					}
					System.out.println("Enter value2 : ");
					try 
					{
						b = sc.nextBigInteger();
					}
					catch(InputMismatchException e)
					{
						System.out.println("InputMismatchException is ocuured");
					}
					System.out.println("Multiplication value of "+a+" and "+b+" is "+ cal.multiply(a, b));
					break;
				}
				case 4:
				{
					try 
					{
						a = sc.nextBigInteger();
					}
					catch(InputMismatchException e)
					{
						System.out.println("InputMismatchException is ocuured");
					}
					System.out.println("Enter value2 : ");
					try 
					{
						b = sc.nextBigInteger();
					}
					catch(InputMismatchException e)
					{
						System.out.println("InputMismatchException is ocuured");
					}
					System.out.println("Division value of "+a+" and "+b+" is "+ cal.division(a, b));
					break;
				}
				case 5:
				{
					try 
					{
						a = sc.nextBigInteger();
					}
					catch(InputMismatchException e)
					{
						System.out.println("InputMismatchException is ocuured");
					}
					System.out.println("Power of two value of "+a+" is "+ cal.powerOfTwo(a));
					break;
				}
				case 6:
				{
					break;
				}
				default:
				{
					System.out.println("Enter the valid choice");
				}
			}
		}
		System.out.println("Calculation is finished");
	}
}
