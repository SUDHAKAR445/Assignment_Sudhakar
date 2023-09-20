package sortingAlgorithm;

import java.util.Scanner;

public class Main 
{
	public static void print(int arr[], int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size : ");
		int n = sc.nextInt();
		System.out.println("\nEnter the array elements : ");
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		System.out.println("Sorting: \n 1.Insertion Sort \n 2.Bubble Sort"
				+ "\n 3.Selection Sort \n 4.Merge Sort \n 5.Quick Sort ");
		System.out.println("Enter the choice : ");
		int choice = sc.nextInt();
		if(choice == 1)
		{
			InsertionSorting i = new InsertionSorting();
			i.InsertionSort(arr, n);
			System.out.println("After perform the Insertion sorting : ");
			print(arr,n);
		}
		else if(choice == 2)
		{
			BubbleSorting b = new BubbleSorting();
			b.bubbleSort(arr, n);
			System.out.println("After perform the Bubble sorting : ");
			print(arr,n);
		}
		else if(choice == 3)
		{
			SelectionSorting s = new SelectionSorting();
			s.selectionSort(arr, n);
			System.out.println("After perform the Selection sorting : ");
			print(arr,n);
		}
		else if(choice == 4)
		{
			MergeSorting m = new MergeSorting();
			m.mergeSort(arr, 0, n-1);
			System.out.println("After perform the Merge sorting : ");
			print(arr,n);
		}
		else if( choice == 5)
		{
			QuickSorting q = new QuickSorting();
			q.quickSort(arr, 0, n-1);
			System.out.println("After perform the Quick sorting : ");
			print(arr,n);
		}
		sc.close();
	}
}