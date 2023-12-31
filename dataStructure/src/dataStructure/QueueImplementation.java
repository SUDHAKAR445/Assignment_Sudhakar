package dataStructure;

import java.util.Scanner;

class Queue {   
    
    private static int front, rear, capacity;   
    private static int queue[];   
     
    Queue(int size) {   
        front = rear = 0;   
        capacity = size;   
        queue = new int[capacity];   
    }   
     
    void queueEnqueue(int item) 
    {    
        if (capacity == rear) 
        {   
            System.out.printf("\nQueue is full\n");   
            return;   
        }     
        else 
        {   
            queue[rear] = item;   
            rear++;   
        }   
        return;   
    }   
    
    void queueDequeue()  
    {   
        if (front == rear)
        {   
            System.out.printf("\nQueue is empty\n");   
            return;   
        }    
        else
        {   
            for (int i = 0; i < rear - 1; i++) 
            {   
                queue[i] = queue[i + 1];   
            }     
            if (rear < capacity)   
                queue[rear] = 0;      
            rear--;   
        }   
        return;   
    }   
        
    void queueDisplay()   
    {   
        int i;   
        if (front == rear)
        {   
            System.out.printf("Queue is Empty\n");   
            return;   
        }   
        for (i = front; i < rear; i++) 
        {   
            System.out.printf(" %d , ", queue[i]);   
        }   
        return;   
    }   
    
    void queueFront()   
    {   
        if (front == rear) {   
            System.out.printf("Queue is Empty\n");   
            return;   
        }   
        System.out.printf("\nFront Element of the queue: %d", queue[front]);   
        return;   
    }  
    void isFull()
    {
    	if((rear-front)== queue.length-1)
    	{
    		System.out.println("Queue is Full");
    	}
    	else
    	{
    		System.out.println("Queue is not Full");
    	}
    }
    void isEmpty()
    {
    	if(front == -1 && rear == -1)
    	{
    		System.out.println("Queue is empty");
    	}
    	else
    	{
    		System.out.println("Queue is not empty");
    	}
    }
    void size()
    {
    	if(front == -1 && rear == -1)
    	{
    		System.out.println("Queue size is 0");
    	}
    	else
    	{
    		System.out.println("Queue size is "+ (rear-front));
    	}
    }
}   
public class QueueImplementation 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the queue :");
		int n = sc.nextInt();
		Queue queue = new Queue(n);
		int choice = -1;
		while(choice != 0)
		{
			System.out.println("Enter the choice : \n 1.Enqueue \n 2.Dequeue \n 3.Front \n 4.isFull \n 5.isEmpty \n 6.size \n 7.display \n 0.Exit");
			choice = sc.nextInt();
			switch(choice)
			{
			    case 0:
			    {
			    	break;
			    }
				case 1:
				{
					System.out.println("Enter the value to enqueue in the queue : ");
					int val = sc.nextInt();
					queue.queueEnqueue(val);
					break;
				}
				case 2:
				{
					queue.queueDequeue();
					break;
				}
				case 3:
				{
					queue.queueFront();
					break;
				}
				case 4:
				{
					queue.isFull();
					break;
				}
				case 5:
				{
					queue.isEmpty();
					break;
				}
				case 6:
				{
					queue.size();
					break;
				}
				case 7:
				{
					queue.queueDisplay();
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
