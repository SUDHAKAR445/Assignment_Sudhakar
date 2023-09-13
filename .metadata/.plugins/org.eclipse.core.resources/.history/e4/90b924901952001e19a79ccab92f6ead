package dataStructure;

import java.util.Scanner;

class CDLLNode{
    int data;
    CDLLNode prev;
    CDLLNode next;
    int size=0;
    CDLLNode(){}
    CDLLNode(int val){
        data=val;
        prev=null;
        next=null;
    }
    CDLLNode head=null;
    CDLLNode tail=null;
    void addFirst(int val){
        CDLLNode newCDLLNode = new CDLLNode(val);
        if(head==null){
            head=newCDLLNode;
            tail=newCDLLNode;
            head.prev=head;
            head.next=head;
            size++;
        }
        else{
            newCDLLNode.next=head;
            head.prev=newCDLLNode;
            tail.next=newCDLLNode;
            newCDLLNode.prev=tail;
            head=newCDLLNode;
            size++;
        }
    }
    void addLast(int val){
        if(head==null){
            addFirst(val);
            return;
        }
        CDLLNode newCDLLNode = new CDLLNode(val);
        tail.next=newCDLLNode;
        newCDLLNode.prev=tail;
        newCDLLNode.next=head;
        head.prev=newCDLLNode;
        tail=newCDLLNode;
        size++;
    }
    void addAtPos(int pos, int val){
        if(head==null){
            addFirst(val);
            return;
        }
        if(pos>size){
            addLast(val);
            return;
        }
        if(pos<=0){
            addFirst(val);
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
    void delFirst(){
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
    void delLast(){
        CDLLNode temp=head;
        if(head==null)
            System.out.println("List is empty");
        else{
            while(temp.next!=tail)
                temp=temp.next;
            temp.next.prev=null;
            temp.next.next=null;
            temp.next=head;
            tail=temp;
            head.prev=tail;
            size--;
        }

    }
    void delAtPos(int pos){
        CDLLNode temp=head;
        if(head==null)
            System.out.println("List is empty"); 
        if(pos<0||pos>=size){
            System.out.println("Invalid position");
            return;
        }
        if(pos==0){
            delFirst();
            return;
        }
        if(pos==size-1){
            delLast();
            return;
        }
        else{
            for(int i=0;i<pos;i++)
                temp=temp.next;
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
            temp.prev=null;
            temp.next=null;
            size--;
        } 
    }
    void display(){
        CDLLNode curr=head;
        System.out.println();
        while(curr.next!=head){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println(curr.data);
        System.out.println();
    }
    void search(int val){
        if(head==null)
        {
            System.out.println("\nList empty");
            return;
        }
        CDLLNode curr=head;
        int index=0;
        while(curr.next!=head){
            if(curr.data==val){
                System.out.println("\nThe element is found at index "+index);
                return;
            }
            curr=curr.next;
            index++;
        }
        if(curr.data==val){
            System.out.println("\nThe element is found at index "+index);
            return;
        }
        System.out.println("\nThe element could not be found");
    }

    void displayrev(){
        CDLLNode temp=tail;
        System.out.println();
        while(temp!=head){
            System.out.print(temp.data+" ");
            temp=temp.prev;
        }
        System.out.println(head.data);
        System.out.println();
    }
    
}
public class CircularDoublyLinkedListImplementation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        CDLLNode n=new CDLLNode();
        System.out.println("Enter a choice");
        int choice;
        while(true){
            System.out.println("1.Add First");
            System.out.println("2.Add Last");
            System.out.println("3.Add At particular Position");
            System.out.println("4.Delete First");
            System.out.println("5.Delete Last");
            System.out.println("6.Delete At particular Position");
            System.out.println("7.Search by value");
            System.out.println("8.Display reverse of list");
            System.out.println("9.Display list");
            System.out.println("10.Exit");      
            int val,pos;
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Input element :");
                    val=sc.nextInt();
                    n.addFirst(val);
                    break;
                case 2:
                    System.out.println("Input element :");
                    val=sc.nextInt();
                    n.addLast(val);
                    break;
                case 3:
                    System.out.println("Input element :");
                    val=sc.nextInt();
                    System.out.println("Input position :");
                    pos=sc.nextInt();
                    n.addAtPos(pos, val);
                    break;
                case 4:
                    n.delFirst();
                    break;
                case 5:
                    n.delLast();
                    break;
                case 6:
                    System.out.println("Input position :");
                    pos=sc.nextInt();
                    n.delAtPos(pos);
                    break;
                case 7:
                    System.out.println("Input value to be searched :");
                    val=sc.nextInt();
                    n.search(val);
                    break;
                case 8:
                    n.displayrev();
                    break;
                case 9:
                    n.display();
                    break;
                case 10:
                    return;
                default:
                   System.out.println("Invalid choice");
                   break;
            }
        }
    }
}