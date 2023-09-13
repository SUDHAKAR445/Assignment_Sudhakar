package dataStructure;
import java.util.*;
public class StackImplementation 
{
	private int[] array;
	private int top;
 
	public StackImplementation(int capacity) 
	{
		array = new int[capacity];
		top = -1;
	}
		   
	public void push(int element) 
	{
		if (top == array.length - 1) 
		{
		    System.out.println("StackImplementation is full. Cannot push element.");
		} 
		else 
		{
		    top++;
		    array[top] = element;
		    System.out.println("Pushed element: " + element);
		}
	}
		   
	public void pop() 
	{
		if (top == -1) 
		{
			System.out.println("StackImplementation is empty. Cannot pop element.");
		} 
		else 
		{
		    int poppedElement = array[top];
		    --top;
		    System.out.println("Popped element: " + poppedElement);
		}
	}
		   
	public void peek() 
	{
		if (top == -1) 
		{
		    System.out.println("StackImplementation is empty. No element to peek.");
		} 
		else 
		{
		    System.out.println("Peeked element: " + array[top]);
		}
	}
		   
	public void isEmpty() 
	{
		if(top == -1)
		{
			System.out.println("Stack is empty");
		}
		else
		{
			System.out.println("Stack is not empty");
		}
	}
	public void isFull() 
	{
		if(top == array.length-1)
		{
			System.out.println("Stack is full");
		}
		else
		{
			System.out.println("Stack is not full");
		}
	}
	public void size()
	{
		System.out.println("Stack size is "+ (top+1));
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the stack : ");
		int n = sc.nextInt();
		StackImplementation stack1 = new StackImplementation(n);
		
		int choice = -1;
		while(choice !=0)
		{
			System.out.println("Enter the choice :\n 1.push \n 2.pop \n 3.peek \n 4.isEmpty \n 5.size of the stack \n 6.isFull \n 0.exit");
			choice = sc.nextInt();
			switch(choice)
			{
			    case 0:
			    {
			    	break;
			    }
				case 1:
				{
					System.out.println("Enter the value to push into the stack : ");
					int val = sc.nextInt();
					stack1.push(val);
					break;
				}
				case 2:
				{
					stack1.pop();
					break;
				}
				case 3:
				{
					stack1.peek();
					break;
				}
				case 4:
				{
					stack1.isEmpty();
					break;
				}
				case 5:
				{
					stack1.size();
					break;
				}
				case 6:
				{
					stack1.isFull();
					break;
				}
				default:
				{
					System.out.println("Please enter the valid choice ");
				}
			}
		}
	}
}
