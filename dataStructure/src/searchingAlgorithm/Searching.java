package searchingAlgorithm;

import java.util.*;
public class Searching 
{
	public static int index = 0;
	static boolean linearSearch(int[] arr, int n, int key)
	{
		for(int i=0;i<n;i++)
		{
			if(arr[i] == key)
			{
				index = i+1;
				return true;
			}
		}
		return false;
	}
	static boolean binarySearch(int[] arr, int start, int end, int key)
	{
		while(start<=end)
		{
			int mid = (end+start)/2;
			if(arr[mid] == key)
			{
				index = mid+1;
				return true;
			}
			else if( arr[mid]>key)
			{
				end = mid -1;
			}
			else
			{
				start = mid+1;
			}
		}
		return false;
	}
	static boolean tenarySearch(int arr[], int start, int end, int key)
	{
        if (start <= end) 
        {
 
            int mid1 = start + (end - start) / 3;
            int mid2 = end - (end - start) / 3;
 
            if (arr[mid1] == key) 
            {
            	index = mid1 + 1;
                return true;
            }
            if (arr[mid2] == key) 
            {
            	index = mid2+1;
                return true;
            } 
            if (key < arr[mid1]) 
            {
                return tenarySearch(arr,start, mid1 - 1, key);
            }
            else if (key > arr[mid2]) 
            {
                return tenarySearch(arr,mid2 + 1, end, key);
            }
            else 
            {
                return tenarySearch(arr,mid1 + 1, mid2 - 1, key);
            }
        }
        return false;
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.println("Searching \n 1.Linear Search \n 2.Binary Search (Input must be in sorted order)\n 3.Tenary Search Input must be in sorted order)");
		System.out.println("Enter the choice :");
		choice = sc.nextInt();
		
		System.out.println("Enter the size of an array : ");
		int n = sc.nextInt();
		System.out.println("\nEnter the array elements :");
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]= sc.nextInt();
		}
		
		System.out.println("\nEnter the Search key value : ");
		int searchKey = sc.nextInt();
		if(choice == 1)
		{
			if(linearSearch(arr,n,searchKey))
			{
				System.out.println("Search element is found at the index : "+ index);
			}
			else
			{
				System.out.println("Search element is not found");
			}
		}
		else if(choice == 2)
		{
			if( binarySearch(arr,0, n-1,searchKey))
			{
				System.out.println("Search element is found at the index : "+ index);
			}
			else
			{
				System.out.println("Search element is not found" + index);
			}
		}
		else if( choice == 3)
		{
			if(tenarySearch(arr, 0, n-1, searchKey))
			{
				System.out.println("Search element is found at the index : "+ index);
			}
			else
			{
				System.out.println("Search element is not found" );
			}
		}
		else
		{
			System.out.println("Enter the valid choice");
		}
	}
}
