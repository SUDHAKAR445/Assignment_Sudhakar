package dataStructure;

import java.util.Scanner;

class CDLLNode{
    int data;
    CDLLNode prev;
    CDLLNode next;
    int size=0; //used to track size of an CDLL  
    CDLLNode(){}
    CDLLNode(int val)
    {
        data=val;
        prev=null;
        next=null;
    }
    CDLLNode head=null;
    CDLLNode tail=null;
    
    public void insert(int data) 
    {  
        CDLLNode newNode = new CDLLNode(data);  
        if(head == null) 
        {  
            head = tail = newNode;    
            head.prev = head;    
            tail.next = head;  
        }  
        else 
        {    
            tail.next = newNode;  
            newNode.prev = tail;   
            tail = newNode;  
            tail.next = head;  
        }  
        size++;
    }
    void insertBegin(int val)
    {
        CDLLNode newNode = new CDLLNode(val);
        if(head==null)
        {
            head=newNode;
            tail=newNode;
            
            // when it is one, it need to point itself
            head.prev=head;
            head.next=head;
            size++;
        }
        else
        {
            newNode.next=head;
            head.prev=newNode;
            tail.next=newNode;
            newNode.prev=tail;
            head=newNode;
            size++;
        }
    }
    void insertEnd(int val)
    {
        if(head==null)
        {
            insertBegin(val);
            return;
        }
        else
        {
	        CDLLNode newNode = new CDLLNode(val);
	        tail.next=newNode;
	        newNode.prev=tail;
	        newNode.next=head;
	        head.prev=newNode;
	        tail=newNode;
        }
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
        CDLLNode newCDLLNode=new CDLLNode(val);
        CDLLNode curr=head;
        for(int i=0;i<pos-1;i++)
            curr=curr.next;
        newCDLLNode.next=curr.next;
        newCDLLNode.prev=curr;
        curr.next=newCDLLNode;
        newCDLLNode.next.prev=newCDLLNode;
        size++;
    }
    void deleteBegin(){
        if(head==null)
            System.out.println("List is empty");
        else{
            head=head.next;
            head.prev.next=null;
            head.prev=tail;
            tail.next=head;
            size--;
        }
    }
    void deleteEnd(){
        CDLLNode temp=head;
        if(head==null)
        {
            System.out.println("List is empty");
        }
        else
        {
            while(temp.next!=tail)
            {
                temp=temp.next;
            }
            temp.next.prev=null;
            temp.next.next=null;
            temp.next=head;
            tail=temp;
            head.prev=tail;
            size--;
        }

    }
    void deleteAtPosition(int position)
    {
    	CDLLNode temp = head;
    	CDLLNode nodeToDelete = head;
        if(position < 1 || position > size) 
        {
            System.out.print("\nInvalid position.");
        } 
        else if (position == 1) 
        {
        	  deleteBegin();
        } 
        else if(position == size)
        {
        	deleteEnd();
        }
        else 
        {
            temp = head;
            for(int i = 1; i < position-1; i++)
              temp = temp.next;
            nodeToDelete = temp.next;
            temp.next = temp.next.next;
            temp.next.prev = temp;
            nodeToDelete = null;
            size--;
          }
    	
    }
    void printList()
    {
        CDLLNode curr=head;
        System.out.println();
        while(curr.next!=head)
        {
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println(curr.data);
        System.out.println();
    }
    void search(int val)
    {
        if(head==null)
        {
            System.out.println("\nList empty");
            return;
        }
        CDLLNode curr=head;
        int index=0;
        while(curr.next!=head)
        {
            if(curr.data==val)
            {
                System.out.println("\nThe element is found at index "+index);
                return;
            }
            curr=curr.next;
            index++;
        }
        if(curr.data==val)
        {
            System.out.println("\nThe element is found at index "+index);
            return;
        }
        System.out.println("\nThe element could not be found");
    }

    void reverse()
    {
    	if(head != null) 
    	{
    	    CDLLNode prevNode = head;
    	    CDLLNode tempNode = head;
    	    CDLLNode curNode = head.next;
    	    
    	    //assign next and previous of prevNode as itself to make the first node as last node of the reversed list
    	    prevNode.next = prevNode;
    	    prevNode.prev = prevNode;
    	    
    	    while(curNode != head) 
    	    {
    	      //While the curNode is not head adjust links(unlink curNode and link it to the reversed list from front and modify curNode and prevNode) 
    	      tempNode = curNode.next;

    	      curNode.next = prevNode;
    	      prevNode.prev = curNode;
    	      this.head.next = curNode;
    	      curNode.prev = this.head;

    	      prevNode = curNode;
    	      curNode = tempNode;
    	    }
    	    head = prevNode;
    	  }
    }
    
}
public class CircularDoublyLinkedListImplementation {
	  public static void main(String[] args)
	  {
		    Scanner sc = new Scanner(System.in);
		    CDLLNode list = new CDLLNode();
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
						+ " \n 0.exit");
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
					default :
					{
						System.out.println("Please enter the valid choice ");
					}
					
				}
			}
    }
}