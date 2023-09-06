package exception;
import java.util.*;
class MyException extends Exception 
{
	public MyException(String message) 
	{
		super(message);
	}
}

class ExceptionEg
{
 public static void operation(int value) throws MyException 
 {
     if (value < 0) 
     {
         throw new MyException("Value cannot be negative");
     }
     System.out.println("Operation successful with value: " + value);
 }

 public static void main(String[] args) 
 {
	 Scanner sc = new Scanner(System.in);
	 
	 
	 // OutOfMemoryError 
	 
	 try 
	 {
		 int n = sc.nextInt();
         int[] array = new int[n*n];
     } 
	 catch (OutOfMemoryError e)
	 {
         
         System.out.println("Caught OutOfMemoryError: " + e.getMessage());
         System.out.println("This line will not be executed.");
     }
	 catch(NegativeArraySizeException e)
	 {
		 System.out.println("Caught NegativeArraySizeException: "+ e.getMessage());
	 }
	 catch(InputMismatchException e)
	 {
		 System.out.println("Caught NegativeArraySizeException: "+ e.getMessage());
	 }
	 
	 
	 // StackOverFlowError
	 
	 try 
	 {
		 fib(10);
	 }
	 catch(StackOverflowError e)
	 {
		 System.out.println("Caught stackoverflowerror: "+ e.getMessage());
	 }
	 
	 // User defined exception 
     try
     {
         int inputValue = sc.nextInt();
         operation(inputValue);
     } 
     catch (MyException e) 
     {
         System.out.println("Custom exception caught: " + e.getMessage());
     }
 }

private static void fib(int i) {
	
	fib(i);
}
}
