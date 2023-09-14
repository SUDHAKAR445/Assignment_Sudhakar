package dataStructure;
import java.util.*;
public class LinkedListImplementation 
{
	Node head = null;
	static class Node
	{
		int data;
		Node next;
		
		
		public Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	public static LinkedListImplementation insert(LinkedListImplementation list , int data)
	{
		Node new_node = new Node(data);
		if(list.head == null)
		{
			list.head = new_node;
		}
		else
		{
			Node last = list.head;
			while(last.next != null)
			{
				last = last.next;
			}
			last.next = new_node;
		}
		return list;
	}
	
	public static LinkedListImplementation insertBegin(LinkedListImplementation list , int data)
	{
		Node new_node = new Node(data);
		new_node.next = list.head;
		list.head = new_node;
		return list;
	}
	public static LinkedListImplementation insertEnd(LinkedListImplementation list , int data)
	{
		Node new_node = new Node(data);
		Node last = list.head;
		while(last.next != null)
		{
			last = last.next;
		}
		last.next = new_node;
		return list;
	}
	public static LinkedListImplementation insertAtPosition(LinkedListImplementation list,int data, int position)
	{
		Node temp = list.head;
        if (position < 1)
        {
            System.out.print("Invalid position");
        }
        if (position == 1) 
        {
            Node newNode = new Node(data);
            newNode.next = list.head;
            list.head = newNode;
        } 
        else 
        {
            for(int i=1;i<position - 1;i++)
            {
                list.head=list.head.next;
            }
            
            Node newNode= new Node(data);
            newNode.next=list.head.next;
            list.head.next=newNode;
            list.head = temp;
            
        }
		return list;
	}
	public static void printList(LinkedListImplementation list)
	{
		Node current = list.head;
		System.out.println("Linked List elements are : ");
		
		while(current != null)
		{
			System.out.println(current.data + " ");
			current = current.next;
		}
	}
	public static LinkedListImplementation deleteBegin(LinkedListImplementation list)
	{
		if(list.head == null)
		{
			System.out.println("Nothing to be deleted because list is empty");
		}
		else
		{
			Node temp = list.head;
			list.head = temp.next;
		}
		return list;
	}
	
	public static LinkedListImplementation deleteEnd(LinkedListImplementation list)
	{
		if(list.head == null)
		{
			System.out.println("Nothing to be deleted because list is empty");
		}
		else
		{
			Node prev = null;
			Node curr = list.head;
			while(curr.next != null)
			{
				prev = curr;
				curr = curr.next;
			}
			prev.next = null;
		}
		return list;
	}
	public static LinkedListImplementation deleteAtGivenPosition(LinkedListImplementation list, int position)
	{
		Node temp = list.head;
		Node prev = list.head;
		for(int i =0; i<position; i++)
		{
			if(i == 0 && position == 1)
			{
				list.head = list.head.next;
			}
			else
			{
				if(i == position -1 && temp != null)
				{
					prev.next = temp.next;
				}
				else
				{
					prev = temp;
					if(prev == null)
					{
						break;
					}
					temp = temp.next;
				}
			}
		}
		return list;
	}
	
	public static LinkedListImplementation deleteNode(LinkedListImplementation list, int val)
	{
		if(list.head == null)
		{
			System.out.println("Element not present in the list");
		}
		else if(list.head.data == val)
		{
			if(list.head.next != null)
			{
				list.head.data = list.head.next.data;
				list.head.next = list.head.next.next;
				return list;
			}
			else
			{
				return null;
			}
		}
		else
		{
			Node prev = null;
			Node curr = list.head;
			while(curr.next != null)
			{
				prev = curr;
				curr = curr.next;
				if(curr.data == val)
				{
					break;
				}
			}
			if(curr.next == null)
			{
				prev.next = null;
			}
			else
			{
				prev.next = curr.next;
			}
		}
		return list;
	}
	public static LinkedListImplementation reverse(LinkedListImplementation list)
	{
		Node prev = null;
        Node current = list.head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list.head = prev;
        return list;
	}
	public static void search(LinkedListImplementation list, int key)
	{
		Node current = list.head;  
        int i = 1;  
        boolean flag = false;  
        if(list.head == null) 
        {  
            System.out.println("List is empty");  
        }  
        else 
        {  
            while(current != null) 
            {  
                if(current.data == key) 
                {  
                    flag = true;  
                    break;  
                }  
                i++;  
                current = current.next;  
            }  
        }  
        if(flag)  
             System.out.println("Element is present in the list at the position : " + i);  
        else  
             System.out.println("Element is not present in the list");  
	}
	public static void swapNodes(LinkedListImplementation list, int x, int y) {
        if (x == y) {
            return;
        }

        Node prevX = null;
        Node currX = list.head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null;
        Node currY = list.head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) {
            // One or both of the nodes not found
            return;
        }

        // Update the previous nodes' next pointers
        if (prevX != null) {
            prevX.next = currY;
        } else {
            list.head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        } else {
            list.head = currX;
        }

        // Swap the next pointers of currX and currY
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		LinkedListImplementation list = new LinkedListImplementation();
		System.out.println("Enter the size of the linked list : ");
		int n = sc.nextInt();
		System.out.println("Enter linked list values :");
		for(int i=0;i<n;i++)
		{
			int a = sc.nextInt();
			list= insert(list, a);
		}
		int choice = -1;
		while(choice != 0)
		{
			System.out.println("Enter the choice :\n 1.Insert At Begin \n 2.Insert At End "
					+ "\n 3.Insert At Position \n 4.Delete At Begin "
					+ "\n 5.Delete At End \n 6.Delete at given position"
					+ " \n 7.Delete the particular elemnet \n 8.Reverese the Linked list \n 9.Search the element in linked list "
					+ "\n 10.Swap two nodes using value"
					+ "\n 0.exit");
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
					list = insertBegin(list,val);
					System.out.println("After inserted the value at begin : ");
					printList(list);
					break;
				}
				case 2:
				{
					System.out.println("Enter the value : ");
					int val = sc.nextInt();
					list = insertEnd(list,val);
					System.out.println("After inserted the value at end : ");
					printList(list);
					break;
				}
				case 3:
				{
					System.out.println("Enter the value and the position : ");
					int val = sc.nextInt();
					int position = sc.nextInt();
					list = insertAtPosition(list,val,position);
					System.out.println("After inserted the value at position : ");
					printList(list);
					break;
				}
				case 4:
				{
					deleteBegin(list);
					System.out.println("After deleting element in the begin : ");
					printList(list);
					break;
				}
				case 5:
				{
					deleteEnd(list);
					System.out.println("After deleting element in the end : ");
					printList(list);
					break;
				}
				case 6:
				{
					System.out.println("Enter the position to be deleted : ");
					int position = sc.nextInt();
					deleteAtGivenPosition(list, position);
					System.out.println("After deleting element in the given position : ");
					printList(list);
					break;
				}
				case 7:
				{
					System.out.println("Enter the element to be deleted : ");
					int element = sc.nextInt();
					deleteNode(list, element);
					System.out.println("After deleting element in the Linked list : ");
					printList(list);
					break;
				}
				case 8:
				{
					reverse(list);
					System.out.println("After reversing the linked list : ");
					printList(list);
					//reverse(list);
					break;
				}
				case 9:
				{
					System.out.println("Enter the element to be search in the linked list : ");
					int element = sc.nextInt();
					search(list, element);
					break;
				}
				case 10:
				{
					System.out.println("Enter two elements to be swaped : ");
					int element1 = sc.nextInt();
					int element2 = sc.nextInt();
					swapNodes(list, element1, element2);
					System.out.println("After swap elements in the Linked list : ");
					printList(list);
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
