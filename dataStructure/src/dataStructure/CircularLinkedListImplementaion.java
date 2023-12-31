package dataStructure;
import java.util.*;
public class CircularLinkedListImplementaion 
{
	static class Node 
	{
	    int data;
	    Node next;
	    Node() {}
	    Node(int data) 
	    {
	      this.data = data;
	    }
	  }

	  private Node head;
	  private Node tail;
   
	  public CircularLinkedListImplementaion()
	  {
		  this.head = null;
	      this.tail = null;
	  }

	  public boolean isEmpty() 
	  {
		  return head == null;
	  }
	  public void insert(int data)
	  {
		  Node newNode = new Node(data);
		  if(head == null)
		  {
			  head = newNode;
			  tail = newNode;
		  }
		  else
		  {
			  tail.next = newNode;
			  tail = newNode;
			  tail.next = head;
		  }
		  
	  }
	  public void insertBegin(int data) 
	  {
	    Node newNode = new Node(data);  
	    if (head == null) 
	    {  
	    	head = newNode;
	        tail = newNode;
	        newNode.next = head;
	    } 
	    else 
	    {
	    	Node temp = head;
	        newNode.next = temp;   
	        head = newNode;   
	        tail.next = head;
	    }
	  }
	  public void insertEnd(int data) 
	  { 
	    Node newNode = new Node(data);   
	    if (head == null) 
	    {  
	        head = newNode;
	        tail = newNode;
	        newNode.next = head;
	    } 
	    else 
	    {  
	    	tail.next = newNode;  
	        tail = newNode;   
	        tail.next = head;
	    }
	  }

	  public void insertAtPosition(int data, int position) 
	  {
		  Node temp, newNode;
		  int i, count;
		  newNode = new Node();
		  temp = head;
		  count = size();
		  if (temp == null || size() < position)
		  {
			  System.out.println("Index is greater than size of the list");
		  }
		  else 
		  {
			  newNode.data = data;
			  for (i = 1; i < position - 1; i++) 
			  {
				  temp = temp.next;
			  }
			  newNode.next = temp.next;
			  temp.next = newNode;
		  }
	  }

	  public void deleteBegin() 
	  {
	    if (head == null) 
	    {
	      return;
	    } 
	    else 
	    {
	      if (head != tail) 
	      {
	        head = head.next;
	        tail.next = head;
	      }   
	      else 
	      {
	        head = tail = null;
	      }
	    }
	  }
	  static int Length(Node head)
	  {
	        Node current = head;
	        int count = 0;
	        if (head == null)
	            return 0;
	        else {
	            do {
	                current = current.next;
	                count++;
	            } while (current != head);
	        }
	        return count;
	    }
	  public void deleteAtPosition(int index)
	  {
		    
		  	int len = Length(head);
		    int count = 1;
		    Node previous = head, next = head;
		 
		    if (head == null)
		    {
		        System.out.printf("\nDelete Last List is empty\n");
		    }
		    if (index >= len || index < 0)
		    {
		        System.out.printf("\nIndex is not Found\n");
		    }
		    if (index == 0)
		    {
		        deleteBegin();
		    }
		    while (len > 0)
		    {
		        if (index == count)
		        {
		            previous.next = next.next;
		        }
		        previous = previous.next;
		        next = previous.next;
		        len--;
		        count++;
		    }
	  }
	  public void deleteEnd() 
	  {
	    if (head == null) 
	    {
	    	return;
	    } 
	    else
	    {
	    	if (head != tail) 
	    	{
	    		Node current = head;
	    		while (current.next != tail) 
	    		{
	    			current = current.next;
	    		} 
	    		tail = current;   
	    		tail.next = head;
	    	}  
	    	else 
	    	{
	    		head = tail = null;
	    	}
	    }
	  }

	  public void deleteNode(int data) 
	  {
	    if (head == null)
	    {	
	    	System.out.println("List is empty");
	    }
	    Node curr = head;
	    Node prev = new Node();
	    while (curr.data != data) 
	    {
	    	if (curr.next == head)
	    	{
	    		System.out.println("Given node with data " + data + " is not found in the circular linked list.");
	    		break;
	    	}
	    	prev = curr;
	    	curr = curr.next;
	    } 
	    if (curr == head && curr.next == head) 
	    {
	    	head = null;
	    } 
	    if (curr == head) 
	    {
	    	prev = head;
	    	while (prev.next != head) 
	    	{
	    		prev = prev.next;
	    	}
	    	head = curr.next;
	    	prev.next = head;
	    }
	    else if (curr.next == head) 
	    {
	    	prev.next = head;
	    }
	    else 
	    {
	    	prev.next = curr.next;
	    }
	  }
	  
	  public void printList() 
	  {
		  Node temp = head;
		  if (head != null) 
		  {
			  do {
				  	System.out.printf("%d ", temp.data);
				  	temp = temp.next;
			  	 } while (temp != head);
		  }
		  System.out.printf("\n");
	  }

	  public int size() 
	  {
		  int size = 0;
		  if (head != null) 
		  {
			  Node temp = head;
			  while (temp.next != head) 
			  {
				  temp = temp.next;
				  size++;
			  }
			  size++;
		  }
		  return size;
	  }

	  public void search(int data) 
	  {
		  System.out.println("Searching for data:" + data);   
		  Node current = head;
		  int i = 1;
		  boolean flag = false; 
		  if (head == null) 
		  {
			  System.out.println("List is empty");
		  } 
		  else 
		  {
			  do {  
				  	if (current.data == data) 
				  	{
				  		flag = true;
				  		break;
				  	}
				  	current = current.next;
				  	i++;
			   	 } while (current != head);
			  if (flag)
				  System.out.println("Element is present in the list at the position : " + i);
			  else
				  System.out.println("Element is not present in the list");
		  }
	  }
	  
	  public void reverse()
	  {
	      if (head == null)
	            return ;
	      Node prev = null;
	      Node curr = head;
	      Node next;
	      do {
	    	  next = curr.next;
	          curr.next = prev;
	          prev = curr;
	          curr = next;
	        } while (curr != head);
	        head.next = prev;
	        head = prev;
	  }
	  public static void main(String[] args)
	  {
		    Scanner sc = new Scanner(System.in);
		    CircularLinkedListImplementaion  list = new CircularLinkedListImplementaion ();
			System.out.println("Enter the size of the linked list : ");
			int n = sc.nextInt();
			System.out.println("Enter linked list values :");
			for(int i=0;i<n;i++)
			{
				int a = sc.nextInt();
				list.insert(a);
			}
			int choice = -1;
			while(choice != 0)
			{
				System.out.println("Enter the choice :\n 1.Insert At Begin \n 2.Insert At End "
						+ "\n 3.Insert At Position \n 4.Delete At Begin "
						+ "\n 5.Delete At End \n 6.Delete at given position"
						+ " \n 7.Delete the particular elemnet \n 8.Reverese the Linked list \n 9.Search the element in linked list "
						+ "\n 10. \n 0.exit");
				choice = sc.nextInt();
				switch(choice)
				{
				    case 0:
				    {
				    	break;
				    }
					case 1:
					{
						System.out.println("Enter the value : ");
						int val = sc.nextInt();
						list.insertBegin(val);
						System.out.println("After inserted the value at begin : ");
						list.printList();
						break;
					}
					case 2:
					{
						System.out.println("Enter the value : ");
						int val = sc.nextInt();
						list.insertEnd(val);
						System.out.println("After inserted the value at end : ");
						list.printList();
						break;
					}
					case 3:
					{
						System.out.println("Enter the value and the position : ");
						int val = sc.nextInt();
						int position = sc.nextInt();
						list.insertAtPosition(val,position);
						System.out.println("After inserted the value at position : ");
						list.printList();
						break;
					}
					case 4:
					{
						list.deleteBegin();
						System.out.println("After deleting element in the begin : ");
						list.printList();
						break;
					}
					case 5:
					{
						list.deleteEnd();
						System.out.println("After deleting element in the end : ");
						list.printList();
						break;
					}
					case 6:
					{
						System.out.println("Enter the position to be deleted : ");
						int position = sc.nextInt();
						list.deleteAtPosition(position);
						System.out.println("After deleting element in the given position : ");
						list.printList();
						break;
					}
					case 7:
					{
						System.out.println("Enter the element to be deleted : ");
						int element = sc.nextInt();
						list.deleteNode(element);
						System.out.println("After deleting element in the Linked list : ");
						list.printList();
						break;
					}
					case 8:
					{
						list.reverse();
						System.out.println("After reversing the linked list : ");
						list.printList();
						break;
					}
					case 9:
					{
						System.out.println("Enter the element to be search in the linked list : ");
						int element = sc.nextInt();
						list.search(element);
						break;
					}
					default :
					{
						System.out.println("Please enter the valid choice ");
					}
					
				}
			}
	  }
}
