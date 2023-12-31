package dataStructure;

import java.util.Scanner;


class Node{
    int data;
    Node prev;
    Node next;
    int size=0;
    Node(){}
    Node(int val){
        data=val;
        prev=null;
        next=null;
    }
    Node head=null;
    Node tail=null;
    
    void insert(int val)
    {
    	Node newnode = new Node(val);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
            size++;
        }
        else
        {
        	insertEnd(val);
        }
    }
    void insertBegin(int val)
    {
        Node newnode = new Node(val);
        if(head==null)
        {
            head=newnode;
            tail=newnode;
            size++;
        }
        else
        {
            newnode.next=head;
            head.prev=newnode;
            head=newnode;
            size++;
        }
    }
    void insertEnd(int val){
        if(head==null)
        {
            insertBegin(val);
            return;
        }
        Node newnode = new Node(val);
        tail.next=newnode;
        newnode.prev=tail;
        tail=newnode;
        size++;
    }
    void insertAtPosition(int val, int pos)
    {
    	if(head==null)
        {
            insertBegin(val);
            return;
        }
        if(pos>size)
        {
            insertEnd(val);
            return;
        }
        if(pos<=0){
            insertBegin(val);
            return;
        }
	    Node newnode=new Node(val);
	    Node curr=head;
	    for(int i=0;i<pos-1;i++)
	    {
	        curr=curr.next;
	    }
	    newnode.next=curr.next;
	    newnode.prev=curr;
	    curr.next=newnode;
	    newnode.next.prev=newnode;
	    size++;
    }
    void deleteBegin(){
        if(head==null)
            System.out.println("List is empty");
        else{
            head=head.next;
            head.prev.next=null;
            head.prev=null;
            size--;
        }
    }
    void deleteEnd(){
        Node temp=head;
        if(head==null)
            System.out.println("List is empty");
        else{
            while(temp.next.next!=null)
                temp=temp.next;
            temp.next.prev=null;
            temp.next=null;
            tail=temp;
            size--;
        }

    }
    void deleteAtPosition(int pos)
    {
        Node temp=head;
        if(head==null)
        {
            System.out.println("List is empty"); 
        }
        else if(pos<0||pos>=size)
        {
            System.out.println("Invalid position");
        }
        else if(pos==0)
        {
            deleteBegin();
        }
        else if(pos==size-1)
        {
            deleteEnd();
        }
        else
        {
            for(int i=0;i<pos;i++)
            {
                temp=temp.next;
            }
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
            temp.prev=null;
            temp.next=null;
            size--;
        } 
    }
    void printList(){
        Node curr=head;
        System.out.println();
        while(curr!=null)
        {
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
    void search(int val)
    {
        if(head==null)
        {
            System.out.println("\nList empty");
            return;
        }
        Node curr=head;
        int index=0;
        while(curr!=null){
            if(curr.data==val){
                System.out.println("\nThe element is found at index "+index);
                return;
            }
            curr=curr.next;
            index++;
        }
        System.out.println("\nThe element could not be found");
    }

    public void reverse()
	  {
    	 Node temp = null;
         Node current = head;
         while (current != null) 
         {
             temp = current.prev;
             current.prev = current.next;
             current.next = temp;
             current = current.prev;
         }
         
         if (temp != null) {
             head = temp.prev;
         }
	  }
    public void swapNodes(int x, int y) 
    {
        if (x == y) {
            return; // No need to swap if x and y are the same
        }

        Node nodeX = null, nodeY = null;
        Node current = head;

        while (current != null) {
            if (current.data == x) {
                nodeX = current;
            }
            if (current.data == y) {
                nodeY = current;
            }

            current = current.next;
        }

        if (nodeX == null || nodeY == null) {
            // One or both of the nodes not found
            return;
        }

        // Swap the previous pointers
        Node tempPrev = nodeX.prev;
        nodeX.prev = nodeY.prev;
        nodeY.prev = tempPrev;

        // Swap the next pointers
        Node tempNext = nodeX.next;
        nodeX.next = nodeY.next;
        nodeY.next = tempNext;

        // Update the next node's previous pointer if necessary
        if (nodeX.next != null) {
            nodeX.next.prev = nodeX;
        }
        if (nodeY.next != null) {
            nodeY.next.prev = nodeY;
        }

        // Update the head if one of the swapped nodes was the head
        if (nodeX == head) {
            head = nodeY;
        } else if (nodeY == head) {
            head = nodeX;
        }
    }
    
}
public class DoublyLinkedListImplementation {
	public static void main(String[] args)
	  {
		    Scanner sc = new Scanner(System.in);
		    Node list = new Node();
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
						+ "\n 7.Reverese the Linked list \n 8.Search the element in linked list "
						+ " \n 9.Swap the nodes using values\n 0.exit");
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
						list.insertAtPosition(val,position-1);
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
						list.deleteAtPosition(position-1);
						System.out.println("After deleting element in the given position : ");
						list.printList();
						break;
					}
					case 7:
					{
						list.reverse();
						System.out.println("After reversing the linked list : ");
						list.printList();
						break;
					}
					case 8:
					{
						System.out.println("Enter the element to be search in the linked list : ");
						int element = sc.nextInt();
						list.search(element);
						break;
					}
					case 9:
					{
						System.out.println("Enter two elements to be swaped : ");
						int element1 = sc.nextInt();
						int element2 = sc.nextInt();
						list.swapNodes(element1, element2);
						System.out.println("After swap elements in the Linked list : ");
						list.printList();
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